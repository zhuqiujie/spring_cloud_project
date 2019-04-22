package cn.com.sandi.qywx.wxapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.sandi.qywx.base.jpa.annotation.WithGenericService;


@Entity
@Table(name="Wxapp")
@WithGenericService
public class Wxapp {
	@Id
	@Column(name =  "id")
    private long id;
	@Column(name =  "appname")
    private String appname;
	@Column(name =  "appSerect")
    private String appSerect;
	@Column(name =  "num")
    private Integer num;
	public Wxapp( String appname, String appSerect, Integer num) {
		super();
		this.appname = appname;
		this.appSerect = appSerect;
		this.num = num;
	}
	
	public Wxapp(){}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAppname() {
		return appname;
	}
	public void setAppname(String appname) {
		this.appname = appname;
	}
	public String getAppSerect() {
		return appSerect;
	}
	public void setAppSerect(String appSerect) {
		this.appSerect = appSerect;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
    
    
    
}
