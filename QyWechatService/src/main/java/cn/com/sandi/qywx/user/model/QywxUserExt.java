package cn.com.sandi.qywx.user.model;

import java.io.Serializable;
import java.util.List;

public class QywxUserExt implements Serializable{

    /**
     *
     {
     "userid": "ZouYuFei",
     "name": "邹裕斐",
     "department": [1, 4]
     }
     *
     */
    private String userid;
    private String name;
    private List<Long> department;

    public QywxUserExt() {
    }

    public QywxUserExt(String userid, String name, List<Long> department) {
        this.userid = userid;
        this.name = name;
        this.department = department;
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

    public List<Long> getDepartment() {
        return department;
    }

    public void setDepartment(List<Long> department) {
        this.department = department;
    }
}
