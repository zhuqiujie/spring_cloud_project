package cn.com.sandi.qywx.base.jpa.dao;

import java.io.Serializable;
import java.util.*;


public abstract interface GenericDao<T, PK extends Serializable> {
	  
	  public abstract List<T> getAll();
	
	  public abstract List<T> getAll(int begin, int pageSize);
	
	  public abstract List<T> getAllDistinct(int begin, int pageSize);
	
	  public abstract T get(PK paramPK);
	
	  public abstract boolean exists(PK paramPK);
	
	  public abstract T save(T paramT);
	
	  public abstract T update(T paramT);
	
	  public abstract void remove(PK paramPK);
	
	  public abstract int removeAll(String paramString);
	
	  public abstract List<T> findByNamedQuery(String paramString, Map<String, Object> paramMap, int begin, int pageSize);
	
	  public abstract List<T> findByWhere(String paramString, Map<String, Object> paramMap, int begin, int pageSize);
	
	  public abstract List<T> findByNativeQuery(String paramString, Map<String, Object> paramMap,int begin, int pageSize);
	
	  public abstract List<T> findByProperty(String paramString, Object paramObject, int begin, int pageSize);
	
	  public abstract int countAll();
	
	  public abstract int countByWhere(String paramString, Map<String, Object> paramMap);
	
	  public abstract int countByJPQLQuery(String paramString, Map<String, Object> paramMap);
	
	  public abstract int countByNamedQuery(String paramString, Map<String, Object> paramMap);
	
	  public abstract int countByNativeQuery(String paramString, Map<String, Object> paramMap);
	
	  public abstract int countByProperty(String paramString, Object paramObject);
	
	  public abstract Integer callProcedure(String paramString, List<Object> paramList);
	
	  public abstract void flush();
	
	  public abstract void clear();
	  
	  public abstract void beginTransaction();
	  
	  public abstract void commit();
	
	  public abstract int updateByWhere(String paramString1, String paramString2, Map<String, Object> paramMap);
	
	  public abstract int deleteByWhere(String paramString, Map<String, Object> paramMap);
		 
}
