package cn.com.sandi.qywx.dept.model;


import java.io.Serializable;

/**
 * 用于接受企业微信传过来的部门列表实体类
 */
public class QywxDeptExt implements Serializable{

    /**
     "id": 5,
     "name": "测试部",
     "parentid": 2,
     "order": 100000000
     */

    private Long id;
    private String name;
    private Long parentid;
    private Long order;

    public QywxDeptExt() {
    }

    public QywxDeptExt(Long id, String name, Long parentid, Long order) {
        this.id = id;
        this.name = name;
        this.parentid = parentid;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }
}
