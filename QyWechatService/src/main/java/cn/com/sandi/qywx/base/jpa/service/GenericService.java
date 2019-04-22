package cn.com.sandi.qywx.base.jpa.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;



public interface GenericService<T, PK extends Serializable> {
	List<T> getAll();
	
	List<T> getAll(int begin, int pageSize);
	 
	List<T> getAllDistinct(int begin, int pageSize);
	
	T get(PK id);

	List<T> findByProperty(String propertyName, Object propertyValue,int begin, int pageSize);

	List<T> findByNamedQuery(String queryName, Map<String, Object> paramMap,int begin, int pageSize);

	List<T> findByWhere(String whereJPQL, Map<String,Object> paramMap, int begin, int pageSize);
	
	List<T> findByNativeQuery(String nativeSQL, Map<String,Object> paramMap, int begin, int pageSize);
	
	boolean exists(PK id);
	
	T save(T object);

	void update(T object);
	 
	void remove(PK id);
	
	int removeAll(String tableName);

	public int countAll();
	
	int countByWhere(String whereJPQL, Map<String,Object> paramMap);

	int countByJPQLQuery(String jpql, Map<String,Object> paramMap);

	int countByNamedQuery(String queryName, Map<String,Object> paramMap);

	int countByNativeQuery(String nativeSQL, Map<String,Object> paramMap);

	int countByProperty(String propertyName, Object propertyValue);
	
	public Integer callProcedure(String procedureName, List<Object> paramList);
	
	void flush();
	
	void clear();
	
	int updateByWhere(String updateJPQL,String whereJPQL, Map<String,Object> paramMap);
	
	int deleteByWhere(String whereJPQL,Map<String,Object> paramMap);
}
