package cn.com.sandi.qywx.appInfo.model;

import cn.com.sandi.qywx.base.jpa.annotation.WithGenericService;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name="QYWX_APP_INFO")
@WithGenericService
public class QywxAppInfo implements Serializable {

    @Column(name = "TENANTS_ID")
    private Long tenantsId;

    @Column(name = "ORGANIZER_ID")
    private Long organizerId;

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "AGENT_ID")
    private String agentId;

    @Column(name = "SECRET")
    private String secret;

    @Column(name = "APP_NAME")
    private String appName;//应用名称

    @Column(name = "CORP_ID")
    private String corpId;//企业ID


    public QywxAppInfo() {
    }

    public QywxAppInfo(Long tenantsId, Long organizerId, Long id, String agentId, String secret, String appName, String corpId) {
        this.tenantsId = tenantsId;
        this.organizerId = organizerId;
        this.id = id;
        this.agentId = agentId;
        this.secret = secret;
        this.appName = appName;
        this.corpId = corpId;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }


    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    @Override
    public String toString() {
        return "QywxAppInfo{" +
                "tenantsId=" + tenantsId +
                ", organizerId=" + organizerId +
                ", id=" + id +
                ", agentId='" + agentId + '\'' +
                ", secret='" + secret + '\'' +
                ", appName='" + appName + '\'' +
                ", corpId='" + corpId + '\'' +
                '}';
    }
}
