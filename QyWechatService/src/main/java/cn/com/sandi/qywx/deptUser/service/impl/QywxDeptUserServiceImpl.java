package cn.com.sandi.qywx.deptUser.service.impl;

import ch.qos.logback.classic.Logger;
import cn.com.sandi.qywx.base.jpa.dao.GenericDao;
import cn.com.sandi.qywx.base.myBatis.dao.QueryDao;
import cn.com.sandi.qywx.deptUser.query.QywxDeptUserCriteria;
import cn.com.sandi.qywx.deptUser.service.QywxDeptUserService;
import cn.com.sandi.qywx.deptUser.model.QywxDeptUser;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("qywxDeptUserService")
public class QywxDeptUserServiceImpl implements QywxDeptUserService {

    private static Logger logger = (Logger) LoggerFactory.getLogger(QywxDeptUserServiceImpl.class);

    @Resource
    private QueryDao queryDao;

    @Resource
    private GenericDao<QywxDeptUser, Long> qywxDeptUserDao;


    @Override
    public void insertQYWXDeptUser(QywxDeptUser qywxDeptUser) {
        QywxDeptUser qywxDeptUserDB = qywxDeptUserDao.save(qywxDeptUser);
        logger.info("qywxDeptUser addInfo:"+qywxDeptUserDB.toString());
    }

    @Override
    public void updateQYWXDeptUser(QywxDeptUser qywxDeptUser) {
        QywxDeptUser qywxDeptUserDB = qywxDeptUserDao.update(qywxDeptUser);
        logger.info("qywxDeptUser updateInfo:"+qywxDeptUserDB.toString());
    }

    @Override
    public QywxDeptUser getQYWXDeptUserById(Long id) {
        QywxDeptUser qywxDeptUserDB = qywxDeptUserDao.get(id);
        logger.info("qywxDeptUser Info:"+qywxDeptUserDB.toString());
        return qywxDeptUserDB;
    }

    @Override
    public List<QywxDeptUser> findByDeptId(Long deptId) {

        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("deptId",deptId);
        List<QywxDeptUser> qywxDeptUsers = qywxDeptUserDao.findByWhere("DEPT_ID=:deptId",paramMap,0,0);
        logger.info("fingByDeptId:"+ qywxDeptUsers == null?"":qywxDeptUsers.toString());
        return qywxDeptUsers;
    }

    @Override
    public List<QywxDeptUser> queryQYWXDeptUserList(QywxDeptUserCriteria criteria) {

        List<QywxDeptUser> qywxDeptUsers = queryDao.queryForList("qywxDeptUser.queryAll",criteria);
        logger.info("fingByDeptId:"+ qywxDeptUsers == null?"":qywxDeptUsers.toString());

        return qywxDeptUsers;
    }

    @Override
    public QywxDeptUser getDeptUserByDeptIdAndUserId(Long deptId, Long userId) {

        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("deptId",deptId);
        paramMap.put("userId",userId);

        List<QywxDeptUser> deptUsers = qywxDeptUserDao.findByWhere("USER_ID=:userId AND DEPT_ID=:deptId",paramMap,0,0);

        if(deptUsers==null || deptUsers.size()<=0){
            return null;
        }

        return deptUsers.get(0);
    }
}
