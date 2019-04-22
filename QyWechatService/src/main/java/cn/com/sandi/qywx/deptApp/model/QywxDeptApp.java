package cn.com.sandi.qywx.deptApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="QYWX_DEPT_APP")
public class QywxDeptApp implements Serializable{

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "APP_ID")
    private Long appId;

    @Column(name = "DEPT_ID")
    private Long deptId;

    @Column(name = "CORP_ID")
    private String corpId;//企业ID

    public QywxDeptApp() {
    }

    public QywxDeptApp(Long id, Long appId, Long deptId, String corpId) {
        this.id = id;
        this.appId = appId;
        this.deptId = deptId;
        this.corpId = corpId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    @Override
    public String toString() {
        return "QywxDeptApp{" +
                "id=" + id +
                ", appId='" + appId + '\'' +
                ", deptId=" + deptId +
                ", corpId='" + corpId + '\'' +
                '}';
    }
}
