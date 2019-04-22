package cn.com.sandi.qywx.base.myBatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.com.sandi.qywx.base.myBatis.criteria.PageQueryCriteria;
import cn.com.sandi.qywx.base.myBatis.criteria.QueryCriteria;
import ch.qos.logback.classic.Logger;

@SuppressWarnings("rawtypes")
@Component(value="queryDao")
public class QueryDaoImpl implements QueryDao{
	@Resource
    private SqlSessionTemplate sqlSessionTemplate;
	private Logger logger=(Logger) LoggerFactory.getLogger(QueryDaoImpl.class);
	
	public List queryForList(String paramString) {
		RowBounds rowBounds=new RowBounds(0,5000);
		return sqlSessionTemplate.selectList(paramString,rowBounds);
	}

	public List queryForList(String paramString,
			QueryCriteria paramQueryCriteria) {
		RowBounds rowBounds=new RowBounds(0,5000);
		return sqlSessionTemplate.selectList(paramString, paramQueryCriteria,rowBounds);
	}
	
	public int queryForCount(String paramString,
			QueryCriteria paramQueryCriteria) {
         return sqlSessionTemplate.selectOne(paramString, paramQueryCriteria);
	}
 
	public Map queryForListPage(String listStatementName, String countStatementName, PageQueryCriteria queryCriteria){
		Map queryListMap = new HashMap();
	    try {
	      queryCriteria.setIndex((queryCriteria.getCurrentPage() - 1) * queryCriteria.getRows());
	      queryCriteria.setSort(queryCriteria.getSort());
	      queryCriteria.setOrder(queryCriteria.getOrder());
	      List queryList = this.queryForList(listStatementName, queryCriteria);
	      int size = this.queryForCount(countStatementName, queryCriteria);
	      queryCriteria.setPageCount(size % queryCriteria.getRows() != 0 ? size / 
	      queryCriteria.getRows() + 1 : size / queryCriteria.getRows());
	      queryListMap.put("total", Integer.valueOf(size));
	      queryListMap.put("rows", queryList);
	      return queryListMap;
	    } catch (Exception e) {
	        logger.error(e.getLocalizedMessage());
	        return queryListMap;
	    }
	 }
	
	 public int insert(String statement, Object parameter){
		 return this.sqlSessionTemplate.insert(statement, parameter);
	 }
	 
	 public int update(String statement, Object parameter) {
		 return this.sqlSessionTemplate.update(statement, parameter);
	 }
	 
	 public int delete(String statement, Object parameter) {
	    return this.sqlSessionTemplate.delete(statement, parameter);
	 }
}
