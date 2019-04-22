package cn.com.sandi.qywx.base.myBatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.sandi.qywx.base.myBatis.criteria.PageQueryCriteria;
import cn.com.sandi.qywx.base.myBatis.criteria.QueryCriteria;




@SuppressWarnings("rawtypes")
@Repository
public interface QueryDao {
	public List queryForList(String paramString);

    public int queryForCount(String paramString, QueryCriteria paramQueryCriteria);

	public List queryForList(String paramString, QueryCriteria paramQueryCriteria);

	public Map queryForListPage(String listStatementName, String countStatementName, PageQueryCriteria queryCriteria);
	
    public int insert(String statement, Object parameter);
	
	public int update(String statement, Object parameter);
	
	public int delete(String statement, Object parameter);
}
