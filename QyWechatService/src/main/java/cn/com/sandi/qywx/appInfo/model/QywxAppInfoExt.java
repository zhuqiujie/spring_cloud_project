package cn.com.sandi.qywx.appInfo.model;

import cn.com.sandi.qywx.base.jpa.annotation.WithGenericService;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


public class QywxAppInfoExt implements Serializable {

    private Long tenantsId;

    private Long organizerId;

    private Long id;

    private String agentId;

    private String secret;

    private String appName;//应用名称

    private String corpId;//企业ID

    private String access_token;//应用令牌

    public QywxAppInfoExt() {
    }

    public QywxAppInfoExt(Long tenantsId, Long organizerId, Long id, String agentId, String secret, String appName, String corpId, String access_token) {
        this.tenantsId = tenantsId;
        this.organizerId = organizerId;
        this.id = id;
        this.agentId = agentId;
        this.secret = secret;
        this.appName = appName;
        this.corpId = corpId;
        this.access_token = access_token;
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

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    @Override
    public String toString() {
        return "QywxAppInfoExt{" +
                "tenantsId=" + tenantsId +
                ", organizerId=" + organizerId +
                ", id=" + id +
                ", agentId='" + agentId + '\'' +
                ", secret='" + secret + '\'' +
                ", appName='" + appName + '\'' +
                ", corpId='" + corpId + '\'' +
                ", access_token='" + access_token + '\'' +
                '}';
    }
}
