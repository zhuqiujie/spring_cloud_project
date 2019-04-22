package cn.com.sandi.qywx.user.service.impl;

import ch.qos.logback.classic.Logger;
import cn.com.sandi.qywx.base.jpa.dao.GenericDao;
import cn.com.sandi.qywx.user.model.QywxUser;
import cn.com.sandi.qywx.user.service.QywxUserService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("qywxUserService")
public class QywxUserServiceImpl implements QywxUserService {
    private static Logger logger = (Logger) LoggerFactory.getLogger(QywxUserServiceImpl.class);


    @Resource
    private GenericDao<QywxUser, Long> qywxUserDao;

    @Override
    public QywxUser getUserByCorpIdAndCorpUserId(String corpId, String corpUserId) {

        Map<String,Object> paraMap = new HashMap<>();

        paraMap.put("corpId",corpId);
        paraMap.put("corpUserId",corpUserId);


       List<QywxUser> qywxUsers = qywxUserDao.findByWhere("CORP_USER_ID=:corpUserId AND CORP_ID=:corpId",paraMap,
               0,0);

       if(qywxUsers == null || qywxUsers.size() <= 0){
           return null;
       }
        return qywxUsers.get(0);
    }

    @Override
    public QywxUser saveQywxUser(QywxUser qywxUser) {
        QywxUser qywxUserDB;
        if(qywxUser.getId() == null){
            qywxUserDB = qywxUserDao.save(qywxUser);
        }

        qywxUserDB = qywxUserDao.update(qywxUser);

        return qywxUserDB;
    }
}
