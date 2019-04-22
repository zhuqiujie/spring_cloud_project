package cn.com.sandi.qywx.deptChild.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="QYWX_DEPT_CHILD")
public class QywxDeptChild implements Serializable {

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "DEPT_ID")
    private Long deptId;//对应QYWX_DEPT中的ID
    @Column(name = "CHILD_ID")
    private Long childId;//对应QYWX_DEPT中的ID

    @Column(name = "CORP_ID")
    private String corpId;//企业ID

    public QywxDeptChild() {
    }

    public QywxDeptChild(Long id, Long deptId, Long childId, String corpId) {
        this.id = id;
        this.deptId = deptId;
        this.childId = childId;
        this.corpId = corpId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    @Override
    public String toString() {
        return "QywxDeptChild{" +
                "id=" + id +
                ", deptId=" + deptId +
                ", childId=" + childId +
                ", corpId='" + corpId + '\'' +
                '}';
    }
}
