package cn.com.sandi.qywx.corpInfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="QYWX_CORP_INFO")
public class QywxCorpInfo implements Serializable{
    @Column(name = "TENANTS_ID")
    private Long tenantsId;

    @Column(name = "ORGANIZER_ID")
    private Long organizerId;

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "CORP_ID")
    private String corpId;//企业ID
    @Column(name = "CORP_LOGO")
    private String corpLogo;
    @Column(name = "FULL_NAME")
    private String fullName;//全称
    @Column(name = "SHORT_NAME")
    private String shortName;//简称
    @Column(name = "CORP_TYPE")
    private String corpType;//主体类型
    @Column(name = "CORP_ADRESS")
    private String corpAdress;
    @Column(name = "TELEPHONE")
    private String telePhone;
    @Column(name = "CORP_DNS")
    private String corpDNS;//域名
    @Column(name = "STAFF_NUM")
    private Long staffNum;//员工数量
    @Column(name = "DEPT_NUM")
    private Long deptNum;//部门数量
    @Column(name = "LIMIT_NUM")
    private Long limitNum;//人数上限
    @Column(name = "INVOICE")
    private String invoice;//发票抬头
    @Column(name = "TRADE_TYPE")
    private String tradeType;//行业类型
    @Column(name = "STAF_SCALE")
    private String stafScale;//人员规模  1~100人
    @Column(name = "CREATE_DATE")
    private Date createDate;//创建时间

    public QywxCorpInfo() {
    }

    public QywxCorpInfo(Long tenantsId, Long organizerId, Long id, String corpId, String corpLogo, String fullName, String shortName, String corpType, String corpAdress, String telePhone, String corpDNS, Long staffNum, Long deptNum, Long limitNum, String invoice, String tradeType, String stafScale, Date createDate) {
        this.tenantsId = tenantsId;
        this.organizerId = organizerId;
        this.id = id;
        this.corpId = corpId;
        this.corpLogo = corpLogo;
        this.fullName = fullName;
        this.shortName = shortName;
        this.corpType = corpType;
        this.corpAdress = corpAdress;
        this.telePhone = telePhone;
        this.corpDNS = corpDNS;
        this.staffNum = staffNum;
        this.deptNum = deptNum;
        this.limitNum = limitNum;
        this.invoice = invoice;
        this.tradeType = tradeType;
        this.stafScale = stafScale;
        this.createDate = createDate;
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

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public String getCorpLogo() {
        return corpLogo;
    }

    public void setCorpLogo(String corpLogo) {
        this.corpLogo = corpLogo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getCorpType() {
        return corpType;
    }

    public void setCorpType(String corpType) {
        this.corpType = corpType;
    }

    public String getCorpAdress() {
        return corpAdress;
    }

    public void setCorpAdress(String corpAdress) {
        this.corpAdress = corpAdress;
    }

    public String getTelePhone() {
        return telePhone;
    }

    public void setTelePhone(String telePhone) {
        this.telePhone = telePhone;
    }

    public String getCorpDNS() {
        return corpDNS;
    }

    public void setCorpDNS(String corpDNS) {
        this.corpDNS = corpDNS;
    }

    public Long getStaffNum() {
        return staffNum;
    }

    public void setStaffNum(Long staffNum) {
        this.staffNum = staffNum;
    }

    public Long getDeptNum() {
        return deptNum;
    }

    public void setDeptNum(Long deptNum) {
        this.deptNum = deptNum;
    }

    public Long getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(Long limitNum) {
        this.limitNum = limitNum;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getStafScale() {
        return stafScale;
    }

    public void setStafScale(String stafScale) {
        this.stafScale = stafScale;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "QywxCorpInfo{" +
                "tenantsId=" + tenantsId +
                ", organizerId=" + organizerId +
                ", id=" + id +
                ", corpId='" + corpId + '\'' +
                ", corpLogo='" + corpLogo + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", corpType='" + corpType + '\'' +
                ", corpAdress='" + corpAdress + '\'' +
                ", telePhone='" + telePhone + '\'' +
                ", corpDNS='" + corpDNS + '\'' +
                ", staffNum=" + staffNum +
                ", deptNum=" + deptNum +
                ", limitNum=" + limitNum +
                ", invoice='" + invoice + '\'' +
                ", tradeType='" + tradeType + '\'' +
                ", stafScale='" + stafScale + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
