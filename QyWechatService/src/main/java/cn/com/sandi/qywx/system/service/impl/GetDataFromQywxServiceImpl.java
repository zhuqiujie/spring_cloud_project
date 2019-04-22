package cn.com.sandi.qywx.system.service.impl;

import cn.com.sandi.qywx.appInfo.model.QywxAppInfoExt;
import cn.com.sandi.qywx.base.utils.QywxHttpUtils;
import cn.com.sandi.qywx.base.utils.UrlsConstants;
import cn.com.sandi.qywx.system.service.GetDataFromQywxService;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("getDataFromQywxService")
public class GetDataFromQywxServiceImpl implements GetDataFromQywxService{

    private static Logger logger = (Logger) LoggerFactory.getLogger(GetDataFromQywxServiceImpl.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public String getQywxToken(String corpId, String agentId) {
        String jsonStr = stringRedisTemplate.opsForValue().get(corpId+"_"+agentId);

        if(jsonStr == null || jsonStr.equals("")){
            logger.info("获取不到"+agentId+"的token");
            return null;
        }

        QywxAppInfoExt qywxAppInfoExt = JSON.parseObject(jsonStr, QywxAppInfoExt.class);

        String token = qywxAppInfoExt.getAccess_token();

        if(token!=null){
            logger.info(agentId+"：的token是"+token);
        }else{
            logger.info("获取不到"+agentId+"的token");
            return null;
        }
        return token;
    }



    /**
     *  //根据corpId agentId获取全部部门
     * @param corpId
     * @param agentId
     * @param id 获取指定部门及其下的子部门。 如果不填，默认获取全量组织架构
     * @return
     */
    public String getDeptByAgentIdFromQywx(String corpId,String agentId,String id){
        //获取token
        String token = this.getQywxToken(corpId, agentId);
        if (token == null) return null;

        Map<String,Object> paraMap = new HashMap<>();

        paraMap.put(UrlsConstants.ACCESS_TOKEN,token);

        if(id != null && !id.equals("")){
            paraMap.put(UrlsConstants.GET_DEPTLIST_ID,id);
        }

        String returnStr = QywxHttpUtils.doGet(UrlsConstants.GET_DEPTLIST_URL,paraMap);

        return returnStr;
    }


    /**
     * 获取当前部门的所有的user详情
     * @param corpId
     * @param agentId
     * @param corpDeptId
     * @param fetchChild
     * @return
     */
    public String getUserByCorpIdFromQywx(String corpId,String agentId,Long corpDeptId,Integer fetchChild){
        //获取token
        String token = this.getQywxToken(corpId, agentId);
        if (token == null) return null;
        Map<String,Object> paraMap = new HashMap<>();

        paraMap.put(UrlsConstants.ACCESS_TOKEN,token);
        paraMap.put(UrlsConstants.GET_USER_BYDEPTID_DEPARTMENT_ID,corpDeptId);

        if(fetchChild!=null){
            paraMap.put(UrlsConstants.GET_USER_BYDEPTID_FETCH_CHILD,fetchChild);
        }

        String returnStr = QywxHttpUtils.doGet(UrlsConstants.GET_USERDETAIL_BYDEPTID_URL,paraMap);

        return returnStr;
    }

    public String getUserInfoFromQywx(String corpId,String agentId,String code){
        //获取token
        String token = this.getQywxToken(corpId, agentId);
        if (token == null) return null;

        Map<String,Object> paraMap = new HashMap<>();

        paraMap.put(UrlsConstants.ACCESS_TOKEN,token);
        paraMap.put(UrlsConstants.GET_USERINFO_BYCODE_CODE,code);

        String returnStr = QywxHttpUtils.doGet(UrlsConstants.GET_USERINFO_BYCODE_URL,paraMap);

        return returnStr;
    }

}
