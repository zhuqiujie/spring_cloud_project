package cn.com.sandi.qywx.dept.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="QYWX_DEPT")
public class QywxDept implements Serializable {
    @Column(name="TENANTS_ID")
    private Long tenantsId;

    @Column(name="ORGANIZER_ID")
    private Long organizerId;

    @Column(name = "CORP_ID")
    private String corpId;

//    @Column(name = "AGENT_ID")
//    private String agentId;

    @Id
    @Column(name="ID")//主键
    private Long id;

    @Column(name="DEPT_NAME")
    private String deptName;

    @Column(name="PARENT_ID")
    private Long parentId;

    @Column(name="CORP_DEPT_ID")
    private Long corpDeptId;//可用于标志部门的层次

    @Column(name="DEPT_ORDER")
    private Long deptOrder;

    public QywxDept() {
    }

    public QywxDept(Long tenantsId, Long organizerId, String corpId, Long id, String deptName, Long parentId, Long corpDeptId, Long deptOrder) {
        this.tenantsId = tenantsId;
        this.organizerId = organizerId;
        this.corpId = corpId;
        this.id = id;
        this.deptName = deptName;
        this.parentId = parentId;
        this.corpDeptId = corpDeptId;
        this.deptOrder = deptOrder;
    }

    public Long getTenantsId() {
        return tenantsId;
    }

    public void setTenantsId(Long tenantsId) {
        this.tenantsId = tenantsId;
    }

    public Long getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Long organizerId) {
        this.organizerId = organizerId;
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getCorpDeptId() {
        return corpDeptId;
    }

    public void setCorpDeptId(Long corpDeptId) {
        this.corpDeptId = corpDeptId;
    }

    public Long getDeptOrder() {
        return deptOrder;
    }

    public void setDeptOrder(Long deptOrder) {
        this.deptOrder = deptOrder;
    }

    @Override
    public String toString() {
        return "QywxDept{" +
                "tenantsId=" + tenantsId +
                ", organizerId=" + organizerId +
                ", corpId='" + corpId + '\'' +
                ", id=" + id +
                ", deptName='" + deptName + '\'' +
                ", parentId=" + parentId +
                ", corpDeptId=" + corpDeptId +
                ", deptOrder=" + deptOrder +
                '}';
    }
}
