package cn.com.sandi.qywx.deptApp.service;

import cn.com.sandi.qywx.deptApp.model.QywxDeptApp;

public interface QywxDeptAppService {

    public QywxDeptApp saveDeptApp(QywxDeptApp qywxDeptApp);

    public QywxDeptApp getDeptAppByDeptIdAndAppId(Long deptId,Long appId);

}
