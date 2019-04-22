package cn.com.sandi.qywx.deptUser.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="QYWX_DEPT_USER")
public class QywxDeptUser implements Serializable{

    @Id
    @Column(name="ID")
    private Long id;

    @Column(name = "CORP_ID")
    private String corpId;

//    @Column(name = "AGENT_ID")
//    private String agentId;

    //对应 qywx_user 中的id
    @Column(name="USER_ID")
    private Long userId;

    @Column(name="DEPT_ID")
    private Long deptId;


    /**
     * 部门内的排序值，默认为0，成员次序以创建时间从小到大排列。
     * 数量必须和department一致，数值越大排序越前面。
     * 有效的值范围是[0, 2^32)
     */
    @Column(name="DEPT_ORDER")
    private Long deptOrder;

    /**个数必须和department一致，表示在所在的部门内是否为上级。
     * 1表示为上级，0表示非上级。
     * 在审批等应用里可以用来标识上级审批人
     */
    @Column(name="IS_LEADER_IN_DEPT")
    private Integer isLeaderInDept;

    public QywxDeptUser() {
    }


    public QywxDeptUser(Long id, String corpId, Long userId, Long deptId, Long deptOrder, Integer isLeaderInDept) {
        this.id = id;
        this.corpId = corpId;
        this.userId = userId;
        this.deptId = deptId;
        this.deptOrder = deptOrder;
        this.isLeaderInDept = isLeaderInDept;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }


    @Override
    public String toString() {
        return "QywxDeptUser{" +
                "id=" + id +
                ", corpId='" + corpId + '\'' +
                ", userId=" + userId +
                ", deptId=" + deptId +
                ", deptOrder=" + deptOrder +
                ", isLeaderInDept=" + isLeaderInDept +
                '}';
    }
}
