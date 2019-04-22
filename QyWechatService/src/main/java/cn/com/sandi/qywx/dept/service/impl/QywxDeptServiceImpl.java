package cn.com.sandi.qywx.dept.service.impl;

import ch.qos.logback.classic.Logger;
import cn.com.sandi.qywx.base.jpa.dao.GenericDao;
import cn.com.sandi.qywx.base.myBatis.dao.QueryDao;
import cn.com.sandi.qywx.dept.model.QywxDept;
import cn.com.sandi.qywx.dept.service.QywxDeptService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("qywxDeptService")
public class QywxDeptServiceImpl implements QywxDeptService{
    private static Logger logger = (Logger) LoggerFactory.getLogger(QywxDeptServiceImpl.class);

    @Resource
    private QueryDao queryDao;

    @Resource
    private GenericDao<QywxDept, Long> qywxDeptDao;

    @Override
    public QywxDept saveOrUpdateQywxDept(QywxDept qywxDept) {
        QywxDept qywxDeptDB;
        if(qywxDept.getId()!=null){//更新
            qywxDeptDB = qywxDeptDao.update(qywxDept);
        }else{
            qywxDeptDB = qywxDeptDao.save(qywxDept);
        }
        return qywxDeptDB;
    }


    /**
     * 由企业id 和 企业部门id获取部门信息
     * @param corpId
     * @param corpDeptId
     * @return
     */
    @Override
    public QywxDept getDeptByCorpIdAndCorpDeptId(String corpId, Long corpDeptId) {

        Map<String,Object> paraMap = new HashMap<>();

        paraMap.put("corpId",corpId);

        paraMap.put("corpDeptId",corpDeptId);

        List<QywxDept> deptList = qywxDeptDao.findByWhere(" CORP_ID=:corpId AND CORP_DEPT_ID=:corpDeptId",paraMap,0,0);

        if(deptList == null || deptList.size() <= 0){
            return null;
        }

        return deptList.get(0);
    }

    @Override
    public List<QywxDept> getAllDeptByCorpId(String corpId) {
        Map<String,Object> paraMap = new HashMap<>();
        paraMap.put("corpId",corpId);
        List<QywxDept> deptList = qywxDeptDao.findByWhere(" CORP_ID=:corpId",paraMap,0,0);
        return deptList;
    }

    /**
     * 获取所有的子部门(二级部门)
     * @param parentId
     * @return
     */
    @Override
    public List<QywxDept> getChildDept(String corpId,Long parentId) {


        Map<String,Object> paraMap = new HashMap<>();

        paraMap.put("corpId",corpId);
        paraMap.put("parentId",parentId);
        List<QywxDept> qywxDepts = qywxDeptDao.findByWhere("CORP_ID=:corpId AND PARENT_ID=:parentId",paraMap,0,0);

        return qywxDepts;
    }

    /**
     * 获取所有的子部门
     * @param corpId
     * @param parentId
     */
    @Override
    public List<QywxDept> getAllChildDept(String corpId,Long parentId,List<QywxDept> allChildDepts){
       // List<QywxDept> allChildDepts = new ArrayList<>();
        List<QywxDept> chilDepts = this.getChildDept(corpId,parentId);
        if(chilDepts.size()>0){
            for(QywxDept qywxDept:chilDepts){
                allChildDepts.add(qywxDept);
                getAllChildDept(corpId,qywxDept.getCorpDeptId(),allChildDepts);
            }
        }
        logger.info(allChildDepts.toString());
        return allChildDepts;
    }

    //删除全部部门

   public int deleteDeptByCorpId(String corpId){

       Map<String,Object> paraMap = new HashMap<>();

       paraMap.put("corpId",corpId);
      int count = qywxDeptDao.deleteByWhere("CORP_ID=:corpId",paraMap);
        return count;
    }


}
