package cn.com.sandi.qywx.book.query;

import cn.com.sandi.qywx.base.myBatis.criteria.PageQueryCriteria;

public class BookCriteria extends PageQueryCriteria {
    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    
}
