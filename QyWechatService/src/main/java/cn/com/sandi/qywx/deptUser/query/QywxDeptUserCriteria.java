package cn.com.sandi.qywx.deptUser.query;

import cn.com.sandi.qywx.base.myBatis.criteria.PageQueryCriteria;

public class QywxDeptUserCriteria extends PageQueryCriteria {

    private Long id;

    private String userId;

    private Long deptId;

    private Long deptOrder;

    private Integer isLeaderInDept;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getDeptOrder() {
        return deptOrder;
    }

    public void setDeptOrder(Long deptOrder) {
        this.deptOrder = deptOrder;
    }

    public Integer getIsLeaderInDept() {
        return isLeaderInDept;
    }

    public void setIsLeaderInDept(Integer isLeaderInDept) {
        this.isLeaderInDept = isLeaderInDept;
    }
}
