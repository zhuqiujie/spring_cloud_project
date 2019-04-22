package cn.com.sandi.qywx.user.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class QywxUserDetailExt implements Serializable{

    private String userid;
    private String name;

    private String mobile;

    private List<Long> order;//在部门中的次序

    private List<Long> department;

    private String position;

    private String gender;//性别

    private String email;

    private List<Integer> is_leader_in_dept;

    private String avatar;

    private String telephone;

    private Integer enable;

    private String alias;

    private Integer status;

    private Map<String,Object> extattr;

    private String qr_code;

    private String external_position;

    private Map<String,Object> external_profile;

    private String address;

    public QywxUserDetailExt() {
    }

    public QywxUserDetailExt(String userid, String name, String mobile, List<Long> order, List<Long> department, String position, String gender, String email, List<Integer> is_leader_in_dept, String avatar, String telephone, Integer enable, String alias, Integer status, Map<String, Object> extattr, String qr_code, String external_position, Map<String, Object> external_profile, String address) {
        this.userid = userid;
        this.name = name;
        this.mobile = mobile;
        this.order = order;
        this.department = department;
        this.position = position;
        this.gender = gender;
        this.email = email;
        this.is_leader_in_dept = is_leader_in_dept;
        this.avatar = avatar;
        this.telephone = telephone;
        this.enable = enable;
        this.alias = alias;
        this.status = status;
        this.extattr = extattr;
        this.qr_code = qr_code;
        this.external_position = external_position;
        this.external_profile = external_profile;
        this.address = address;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public List<Long> getOrder() {
        return order;
    }

    public void setOrder(List<Long> order) {
        this.order = order;
    }

    public List<Long> getDepartment() {
        return department;
    }

    public void setDepartment(List<Long> department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Integer> getIs_leader_in_dept() {
        return is_leader_in_dept;
    }

    public void setIs_leader_in_dept(List<Integer> is_leader_in_dept) {
        this.is_leader_in_dept = is_leader_in_dept;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Map<String, Object> getExtattr() {
        return extattr;
    }

    public void setExtattr(Map<String, Object> extattr) {
        this.extattr = extattr;
    }

    public String getQr_code() {
        return qr_code;
    }

    public void setQr_code(String qr_code) {
        this.qr_code = qr_code;
    }

    public String getExternal_position() {
        return external_position;
    }

    public void setExternal_position(String external_position) {
        this.external_position = external_position;
    }

    public Map<String, Object> getExternal_profile() {
        return external_profile;
    }

    public void setExternal_profile(Map<String, Object> external_profile) {
        this.external_profile = external_profile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "QywxUserDetailExt{" +
                "userid='" + userid + '\'' +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", order=" + order +
                ", department=" + department +
                ", position='" + position + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", is_leader_in_dept=" + is_leader_in_dept +
                ", avatar='" + avatar + '\'' +
                ", telephone='" + telephone + '\'' +
                ", enable=" + enable +
                ", alias='" + alias + '\'' +
                ", status=" + status +
                ", extattr=" + extattr +
                ", qr_code='" + qr_code + '\'' +
                ", external_position='" + external_position + '\'' +
                ", external_profile=" + external_profile +
                ", address='" + address + '\'' +
                '}';
    }
}
