package cn.com.sandi.qywx.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="QYWX_USER")
public class QywxUser implements Serializable{

    @Column(name="TENANTS_ID")
    private Long tenantsId;

    @Column(name="ORGANIZER_ID")
    private Long organizerId;

    @Column(name = "CORP_ID")
    private String corpId;

//    @Column(name = "AGENT_ID")
//    private String agentId;

    @Id
    @Column(name="ID")
    private Long id;

    @Column(name="CORP_USER_ID")
    private String corpUserId;

    @Column(name="USER_NAME")
    private String userName;

    @Column(name="ALIAS")
    private String alias;

    @Column(name="MOBILE")
    private String mobile;

    //成员所属部门id列表,不超过20个
    //private String department;

    /**
     * 部门内的排序值，默认为0，成员次序以创建时间从小到大排列。
     * 数量必须和department一致，数值越大排序越前面。
     * 有效的值范围是[0, 2^32)
     */
    //private String order;

    //职务
    @Column(name="POSITION")
    private String position;

    //性别  1表示男性，2表示女性
    @Column(name="GENDER")
    private Integer gender;

    @Column(name="EMAIL")
    private String email;


    //1表示启用成员，0表示禁用成员
    @Column(name="ENABLE")
    private Integer enable;


    //成员头像的mediaid，通过素材管理接口上传图片获得的mediaid
    @Column(name="AVATAR_MEDIAID")
    private String avatarMediaid;

    @Column(name="TELEPHONE")
    private String telephone;

    @Column(name="ADDRESS")
    private String address;
    @Column(name = "STATUS")
    private Integer status;
    @Column(name = "QR_CODE")
    private String qrCode;
    @Column(name = "EXTERNAL_PROFILE")
    private String externalProfile;
    @Column(name = "EXTERNAL_POSITION")
    private String externalPosition;


    /**
     * 自定义字段。
     * 自定义字段需要先在WEB管理端添加，见扩展属性添加方法，
     * 否则忽略未知属性的赋值。与对外属性一致，
     * 不过只支持type=0的文本和type=1的网页类型，
     * 详细描述查看对外属性
     */
    @Column(name="EXTATTR")
    private String extattr;

    public QywxUser() {
    }

    public QywxUser(Long tenantsId, Long organizerId, String corpId, Long id, String corpUserId, String userName, String alias, String mobile, String position, Integer gender, String email, Integer enable, String avatarMediaid, String telephone, String address, Integer status, String qrCode, String externalProfile, String externalPosition, String extattr) {
        this.tenantsId = tenantsId;
        this.organizerId = organizerId;
        this.corpId = corpId;
        this.id = id;
        this.corpUserId = corpUserId;
        this.userName = userName;
        this.alias = alias;
        this.mobile = mobile;
        this.position = position;
        this.gender = gender;
        this.email = email;
        this.enable = enable;
        this.avatarMediaid = avatarMediaid;
        this.telephone = telephone;
        this.address = address;
        this.status = status;
        this.qrCode = qrCode;
        this.externalProfile = externalProfile;
        this.externalPosition = externalPosition;
        this.extattr = extattr;
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

    public String getCorpUserId() {
        return corpUserId;
    }

    public void setCorpUserId(String corpUserId) {
        this.corpUserId = corpUserId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public String getAvatarMediaid() {
        return avatarMediaid;
    }

    public void setAvatarMediaid(String avatarMediaid) {
        this.avatarMediaid = avatarMediaid;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getExtattr() {
        return extattr;
    }

    public void setExtattr(String extattr) {
        this.extattr = extattr;
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public String getExternalPosition() {
        return externalPosition;
    }

    public void setExternalPosition(String externalPosition) {
        this.externalPosition = externalPosition;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }


    public String getExternalProfile() {
        return externalProfile;
    }

    public void setExternalProfile(String externalProfile) {
        this.externalProfile = externalProfile;
    }

    @Override
    public String toString() {
        return "QywxUser{" +
                "tenantsId=" + tenantsId +
                ", organizerId=" + organizerId +
                ", corpId='" + corpId + '\'' +
                ", id=" + id +
                ", corpUserId='" + corpUserId + '\'' +
                ", userName='" + userName + '\'' +
                ", alias='" + alias + '\'' +
                ", mobile='" + mobile + '\'' +
                ", position='" + position + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", enable=" + enable +
                ", avatarMediaid='" + avatarMediaid + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", qrCode='" + qrCode + '\'' +
                ", externalProfile='" + externalProfile + '\'' +
                ", externalPosition='" + externalPosition + '\'' +
                ", extattr='" + extattr + '\'' +
                '}';
    }
}
