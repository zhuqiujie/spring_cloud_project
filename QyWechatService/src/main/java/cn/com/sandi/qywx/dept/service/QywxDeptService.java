package cn.com.sandi.qywx.dept.service;

import cn.com.sandi.qywx.dept.model.QywxDept;

import java.util.List;

public interface QywxDeptService {

    public QywxDept saveOrUpdateQywxDept(QywxDept qywxDept);

    public QywxDept getDeptByCorpIdAndCorpDeptId(String corpId, Long corpDeptId);

    public List<QywxDept> getAllDeptByCorpId(String corpId);

    public List<QywxDept> getChildDept(String corpId, Long parentId);
    public List<QywxDept> getAllChildDept(String corpId, Long parentId, List<QywxDept> allChildDepts);

    public int deleteDeptByCorpId(String corpId);

}
