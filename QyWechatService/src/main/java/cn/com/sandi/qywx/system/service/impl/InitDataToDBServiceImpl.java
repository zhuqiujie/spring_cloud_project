package cn.com.sandi.qywx.system.service.impl;

import cn.com.sandi.qywx.appInfo.model.QywxAppInfo;
import cn.com.sandi.qywx.appInfo.service.QywxAppInfoSevrice;
import cn.com.sandi.qywx.corpInfo.service.QywxCorpInfoService;
import cn.com.sandi.qywx.dept.model.QywxDept;
import cn.com.sandi.qywx.dept.model.QywxDeptExt;
import cn.com.sandi.qywx.dept.service.QywxDeptService;
import cn.com.sandi.qywx.deptApp.model.QywxDeptApp;
import cn.com.sandi.qywx.deptApp.service.QywxDeptAppService;
import cn.com.sandi.qywx.deptChild.model.QywxDeptChild;
import cn.com.sandi.qywx.deptChild.service.QywxDeptChildService;
import cn.com.sandi.qywx.deptUser.model.QywxDeptUser;
import cn.com.sandi.qywx.deptUser.service.QywxDeptUserService;
import cn.com.sandi.qywx.system.service.InitDataToDBService;
import cn.com.sandi.qywx.user.model.QywxUser;
import cn.com.sandi.qywx.user.model.QywxUserDetailExt;
import cn.com.sandi.qywx.user.model.QywxUserExt;
import cn.com.sandi.qywx.user.service.QywxUserService;
import com.alibaba.fastjson.JSON;
import com.github.binarywang.java.emoji.EmojiConverter;
import com.vdurmont.emoji.EmojiParser;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 将从企业微信拿到的数据写库
 *
 */
@Service("initDataToDBService")
public class InitDataToDBServiceImpl implements InitDataToDBService{

    private static Logger logger = (Logger) LoggerFactory.getLogger(InitDataToDBServiceImpl.class);
    @Autowired
    private GetDataFromQywxServiceImpl getDataFromQywxService;

    @Autowired
    private QywxDeptService qywxDeptService;

    @Autowired
    private QywxCorpInfoService qywxCorpInfoService;

    @Autowired
    private QywxDeptAppService qywxDeptAppService;

    @Autowired
    private QywxDeptChildService qywxDeptChildService;
    @Autowired
    private QywxUserService qywxUserService;
    @Autowired
    private QywxDeptUserService qywxDeptUserService;

    @Autowired
    private QywxAppInfoSevrice qywxAppInfoSevrice;
    /**
     * //将企业微信得到的部门列表存库
     * <p>
     * 1、根据id和agentId去重
     * 2、存qywx_dept_child 存qywx_dept_app
     * <p>
     * {
     * "id": 5,
     * "name": "测试部",
     * "parentid": 2,
     * "order": 100000000
     * }
     * 3、存成员列表
     *
     * @param agentId 应用ID
     */
    public void saveDeptUserList(String corpId, String agentId, String deptListStr) {
        if (StringUtils.isBlank(deptListStr)) {
            logger.info("saveDeptList获取企业微信的部门列表失败");
        }
        Long tenId = qywxCorpInfoService.getTenIdByCorpId(corpId);
        Long orgId = qywxCorpInfoService.getOrgIdByCorpId(corpId);

        List<QywxDeptExt> deptExts = JSON.parseArray(deptListStr, QywxDeptExt.class);

        for (QywxDeptExt qywxDeptExt : deptExts) {

            //保存qywx_dept
            QywxDept qywxDeptDB = this.saveQywxDeptByExt(corpId,tenId,orgId,qywxDeptExt);

            //int aa = 1/0;

            //保存成功
            if (qywxDeptDB != null) {

                //保存qywx_dept_app
                this.saveDeptAppByDept(corpId,agentId,qywxDeptDB);
                //保存qywx_dept_user
                this.saveUserList(corpId, agentId, qywxDeptDB.getCorpDeptId(), 1);
            }
        }

        /**
         * 先删除全部关联，再重新建立关系，//重新刷新qywx_dept_child
         */
        this.initDeptChildByCorpId(corpId);

    }

    public void initDeptChildByCorpId(String corpId) {
        QywxDeptChild qywxDeptChild;
        qywxDeptChildService.deleteDeptChildByCorpId(corpId);
        List<QywxDept> listDeptAll = qywxDeptService.getAllDeptByCorpId(corpId);

        for (QywxDept deptDB : listDeptAll) {

            List<QywxDept> qywxDepts = new ArrayList<>();
            List<QywxDept> deptChildList = qywxDeptService.getAllChildDept(corpId, deptDB.getCorpDeptId(), qywxDepts);
            //没有子部门
            if (deptChildList == null || deptChildList.size() <= 0) {
                continue;
            }

            for (QywxDept deptChild : deptChildList) {
                qywxDeptChild = new QywxDeptChild();
                qywxDeptChild.setCorpId(corpId);
                qywxDeptChild.setDeptId(deptDB.getId());
                qywxDeptChild.setChildId(deptChild.getId());

                qywxDeptChildService.saveQywxDeptChild(qywxDeptChild);
            }
        }
    }

    /**
     * "userlist": [
     * {
     * "userid": "ZouYuFei",
     * "name": "邹裕斐",
     * "department": [1, 4]
     * },
     * {
     * "userid": "XinZhongNianHua",
     * "name": "郭灶鹏",
     * "department": [1, 2]
     * }
     * ]
     */
    /**
     * 格式化json数据
     *
     * @param corpId        企业id
     * @param agentId
     * @param cordDeptId    企业部门id
     * @param fetchChild    是否查询子部门成员
     * @return
     */
    public void saveUserList(String corpId, String agentId, Long cordDeptId, Integer fetchChild) {

        Long tenId = qywxCorpInfoService.getTenIdByCorpId(corpId);
        Long orgId = qywxCorpInfoService.getOrgIdByCorpId(corpId);

        String userJsonStr = getDataFromQywxService.getUserByCorpIdFromQywx(corpId, agentId, cordDeptId, fetchChild);

        Map<String, Object> map = JSON.parseObject(userJsonStr);

        String errcode = map.get("errcode").toString();

        if (!errcode.equals("0")) {
            String errmsg = map.get("errmsg").toString();
            logger.info("InitDataToDBService==>getUserListByJsonStr");
            logger.info("获取部门user列表失败！errcode：" + errcode + "=====errmsg:" + errmsg);
        }

        List<QywxUserDetailExt> userExts = JSON.parseArray(map.get("userlist").toString(), QywxUserDetailExt.class);


        if (userExts != null || userExts.size() > 0) {

            for (QywxUserDetailExt userDetailExt : userExts) {

                String corpUserId = userDetailExt.getUserid();
                //是否存在，存在即更新
                this.saveUserByUserExt(corpId,orgId,tenId,userDetailExt);

                List<Long> deptIdList = userDetailExt.getDepartment();
                List<Long> orderList = userDetailExt.getOrder();
                List<Integer> isLeaderInDept = userDetailExt.getIs_leader_in_dept();

                if (deptIdList != null && deptIdList.size() > 0 && orderList !=null && orderList.size()>0) {

                    for(int i=0;i<deptIdList.size();i++){

                        QywxDept qywxDeptDB = qywxDeptService.getDeptByCorpIdAndCorpDeptId(corpId, deptIdList.get(i));

                        QywxUser userDB = qywxUserService.getUserByCorpIdAndCorpUserId(corpId, corpUserId);

                        if (userDB != null && qywxDeptDB != null) {
                            //qywx_dept_user去重
                            QywxDeptUser qywxDeptUser = qywxDeptUserService.getDeptUserByDeptIdAndUserId(qywxDeptDB.getId(), userDB.getId());

                            if (qywxDeptUser == null) {
                                qywxDeptUser = new QywxDeptUser();
                                qywxDeptUser.setUserId(userDB.getId());
                                qywxDeptUser.setDeptId(qywxDeptDB.getId());
                                qywxDeptUser.setDeptOrder(orderList.get(i));//在部门的排序
                                qywxDeptUser.setIsLeaderInDept(isLeaderInDept.get(i));

                                qywxDeptUser.setCorpId(corpId);

                                qywxDeptUserService.insertQYWXDeptUser(qywxDeptUser);

                            }

                        }

                    }

                }
            }

        }
    }

    //保存部门
   public QywxDept saveQywxDeptByExt(String corpId,Long tenId,Long orgId,QywxDeptExt qywxDeptExt){

        //是否存在部门
       QywxDept qywxDeptDB = qywxDeptService.getDeptByCorpIdAndCorpDeptId(corpId,qywxDeptExt.getId());
       QywxDept qywxDept = new QywxDept();

       if(qywxDeptDB!=null){//存在即更新
           qywxDept.setId(qywxDeptDB.getId());
       }

       qywxDept.setCorpId(corpId);
       qywxDept.setDeptName(qywxDeptExt.getName());
       qywxDept.setCorpDeptId(qywxDeptExt.getId());
       qywxDept.setDeptOrder(qywxDeptExt.getOrder());
       qywxDept.setParentId(qywxDeptExt.getParentid());
       qywxDept.setTenantsId(tenId);
       qywxDept.setOrganizerId(orgId);

       QywxDept _qywxDeptDB = qywxDeptService.saveOrUpdateQywxDept(qywxDept);

       return _qywxDeptDB;
   }

   public QywxDeptApp saveDeptAppByDept(String corpId,String agentId,QywxDept qywxDept){

        //是否存在
        QywxAppInfo qywxAppInfo = qywxAppInfoSevrice.getAppInfoByAgentIdAndCorpId(agentId,corpId);
        Long appID = qywxAppInfo.getId();

        QywxDeptApp qywxDeptAppDB = qywxDeptAppService.getDeptAppByDeptIdAndAppId(qywxDept.getId(),appID);

        if(qywxDeptAppDB == null){
            QywxDeptApp qywxDeptApp = new QywxDeptApp();
            qywxDeptApp.setAppId(appID);
            qywxDeptApp.setCorpId(corpId);
            qywxDeptApp.setDeptId(qywxDept.getId());

            qywxDeptApp = qywxDeptAppService.saveDeptApp(qywxDeptApp);
            return qywxDeptApp;
        }

        return qywxDeptAppDB;
    }

    public QywxUser saveUserByUserExt(String corpId,Long orgId,Long tenId, QywxUserDetailExt userDetailExt){

        String corpUserId = userDetailExt.getUserid();
        //是否存在，存在即更新
        QywxUser qywxUserDB = qywxUserService.getUserByCorpIdAndCorpUserId(corpId, corpUserId);
        QywxUser qywxUser = new QywxUser();
        //更新或新增
        if (qywxUserDB != null) {
            qywxUser.setId(qywxUserDB.getId());
        }

            qywxUser.setOrganizerId(orgId);
            qywxUser.setTenantsId(tenId);
            qywxUser.setCorpId(corpId);

            qywxUser.setCorpUserId(corpUserId);
            qywxUser.setUserName(EmojiParser.parseToAliases(userDetailExt.getName()));
            qywxUser.setMobile(userDetailExt.getMobile());
            qywxUser.setPosition(userDetailExt.getPosition());
            qywxUser.setGender(Integer.parseInt(userDetailExt.getGender()));
            qywxUser.setEmail(userDetailExt.getEmail());
            qywxUser.setAvatarMediaid(userDetailExt.getAvatar());
            qywxUser.setTelephone(userDetailExt.getTelephone());
            qywxUser.setEnable(userDetailExt.getEnable());
            qywxUser.setAlias(EmojiParser.parseToAliases(userDetailExt.getAlias()));
            qywxUser.setStatus(userDetailExt.getStatus());
            qywxUser.setExtattr(userDetailExt.getExtattr().toString());
            qywxUser.setQrCode(userDetailExt.getQr_code());

            String externalProfile = userDetailExt.getExternal_profile()==null?null:userDetailExt.getExternal_profile().toString();

            qywxUser.setExternalProfile(externalProfile);
            qywxUser.setExternalPosition(userDetailExt.getExternal_position());
            qywxUser.setAddress(userDetailExt.getAddress());

        QywxUser _qywxUserDB = qywxUserService.saveQywxUser(qywxUser);

        return _qywxUserDB;
    }


}
