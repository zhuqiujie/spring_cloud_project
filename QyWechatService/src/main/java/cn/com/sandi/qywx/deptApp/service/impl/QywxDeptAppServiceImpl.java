package cn.com.sandi.qywx.deptApp.service.impl;


import cn.com.sandi.qywx.base.jpa.dao.GenericDao;
import cn.com.sandi.qywx.deptApp.model.QywxDeptApp;
import cn.com.sandi.qywx.deptApp.service.QywxDeptAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("qywxDeptAppService")
public class QywxDeptAppServiceImpl implements QywxDeptAppService{
    @Resource
    private GenericDao<QywxDeptApp, Long> qywxDeptAppDao;

    @Override
    public QywxDeptApp saveDeptApp(QywxDeptApp qywxDeptApp) {
        QywxDeptApp qywxDeptAppDB = qywxDeptAppDao.save(qywxDeptApp);
        return qywxDeptAppDB;
    }

    @Override
    public QywxDeptApp getDeptAppByDeptIdAndAppId(Long deptId, Long appId) {

        Map<String,Object> paramMap = new HashMap<>();

        paramMap.put("deptId",deptId);
        paramMap.put("appId",appId);

       List<QywxDeptApp> deptApps =  qywxDeptAppDao.findByWhere("DEPT_ID=:deptId AND APP_ID=:appId",paramMap,0,0);

        if(deptApps.size()>0){
           return deptApps.get(0);
        }
        return null;
    }
}
