package cn.com.sandi.qywx.deptChild.service;

import cn.com.sandi.qywx.deptChild.model.QywxDeptChild;

public interface QywxDeptChildService{

    public QywxDeptChild saveQywxDeptChild(QywxDeptChild qywxDeptChild);

    public void deleteDeptChildByCorpId(String corpId);

}
