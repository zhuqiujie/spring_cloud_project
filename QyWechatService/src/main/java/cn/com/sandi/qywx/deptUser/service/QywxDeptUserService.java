package cn.com.sandi.qywx.deptUser.service;

import cn.com.sandi.qywx.deptUser.query.QywxDeptUserCriteria;
import cn.com.sandi.qywx.deptUser.model.QywxDeptUser;

import java.util.List;

public interface QywxDeptUserService {

    public void insertQYWXDeptUser(QywxDeptUser qywxDeptUser);

    public void updateQYWXDeptUser(QywxDeptUser qywxDeptUser);

    public QywxDeptUser getQYWXDeptUserById(Long id);

    public List<QywxDeptUser> findByDeptId(Long deptId);

    public List<QywxDeptUser> queryQYWXDeptUserList(QywxDeptUserCriteria criteria);

    public QywxDeptUser getDeptUserByDeptIdAndUserId(Long deptId, Long userId);

}
