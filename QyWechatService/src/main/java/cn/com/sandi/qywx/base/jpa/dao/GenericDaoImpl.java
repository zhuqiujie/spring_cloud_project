package cn.com.sandi.qywx.base.jpa.dao;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.jpa.SharedEntityManagerCreator;

import cn.com.sandi.qywx.base.id.SnowFlakeUtil;
import ch.qos.logback.classic.Logger;



@SuppressWarnings("rawtypes")
public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK>{
	  private Class<T> entity;

	  static Logger logger = (Logger) LoggerFactory.getLogger(GenericDaoImpl.class);

	  private EntityManager entityManager;
	  
	  private EntityManagerFactory entityManagerFactory; 

	 
	 public GenericDaoImpl(Class<T> entity) {
	       this.entity = entity;
	 }
	 
	  public T save(T t){
		    t = (T) setPK(t);
		    this.entityManager.persist(t);
		    return t;
	  }
   
	  public int deleteByWhere(String whereJPQL, Map<String, Object> paramMap){
		    if (this.entityManager == null) return 0;
		    String jpasql = "DELETE FROM " + this.entity.getSimpleName();
		    if ((whereJPQL != null) && (!whereJPQL.equals(""))) {
		      jpasql = jpasql + " WHERE " + whereJPQL;
		    }
		    Query query = this.entityManager.createQuery(jpasql);
		    if (paramMap != null) {
		      for (Iterator it = paramMap.entrySet().iterator(); it.hasNext(); ) {
		        Map.Entry entry = (Map.Entry)it.next();
		        query.setParameter((String)entry.getKey(), entry.getValue());
		      }
		    }
		    return query.executeUpdate();
	  }
	  
	  public void remove(PK id){
	        Object t = this.entityManager.getReference(this.entity, id);
	        this.entityManager.remove(t);
	  }

	  public int removeAll(String tableName) {
		    if (this.entityManager == null) return 0;
		    String jpasql = "DELETE FROM " + tableName;
		    Query query = this.entityManager.createQuery(jpasql);
		    return query.executeUpdate();
	  }
	  
	  public T update(T t){
		     t = this.entityManager.merge(t);
		     return t;
	  }
	  
	  public int updateByWhere(String updateJPQL, String whereJPQL, Map<String, Object> paramMap){
		   if (this.entityManager == null) return 0;
	
		    String jpasql = "UPDATE " + this.entity.getSimpleName() + " SET " + updateJPQL + " ";
		    if ((whereJPQL != null) && (!whereJPQL.equals(""))) {
		      jpasql = jpasql + " WHERE " + whereJPQL;
		    }
		    Query query = this.entityManager.createQuery(jpasql);
	
		    if (paramMap != null) {
		      for (Iterator it = paramMap.entrySet().iterator(); it.hasNext(); ) {
		        Map.Entry entry = (Map.Entry)it.next();
		        query.setParameter((String)entry.getKey(), entry.getValue());
		      }
		    }
		    return query.executeUpdate();
	  }
	  
	  
	  public T get(PK id){
	      T t = this.entityManager.find(this.entity, id);
	      return t;
	  }

	  public List<T> getAll() {
	    return getAll(-1, -1);
	  }

	  public List<T> getAll(int begin, int pageSize){
	    return findByJPQLQuery(getSelectJPQL(null), null, begin, pageSize);
	  }

	  /**
	   * 去重
	   */
	  public List<T> getAllDistinct(int begin, int pageSize) {
	    Collection result = new LinkedHashSet(getAll(begin, pageSize));
	    return new ArrayList(result);
	  }

	  public List<T> findByNamedQuery(String queryName, Map<String, Object> queryParams, int begin, int pageSize){
	    return findByQuery(queryName, "NAMED", queryParams, begin, pageSize);
	  }

	  public List<T> findByWhere(String whereJPQL, Map<String, Object> paramMap, int begin, int pageSize) {
	    return findByJPQLQuery(getSelectJPQL(whereJPQL), paramMap, begin, pageSize);
	  }
	  
	  public List<T> findByNativeQuery(String nativeSQL, Map<String, Object> paramMap, int begin, int pageSize) {
	    return findByQuery(nativeSQL, "NATIVE", paramMap, begin, pageSize);
	  }

	  public List<T> findByProperty(String propertyName, Object propertyValue, int begin, int pageSize) {
	    String variableName = this.entity.getSimpleName().substring(0, 1).toLowerCase() + this.entity.getSimpleName().substring(1);
	    StringBuilder jpql = new StringBuilder("select ");
	    jpql.append(variableName);
	    jpql.append(" from " + this.entity.getSimpleName() + " ");
	    jpql.append(variableName);
	    jpql.append(" where ");
	    jpql.append(variableName);
	    jpql.append("." + propertyName + "=:" + propertyName);
	    Map paramMap = new HashMap();
	    paramMap.put(propertyName, propertyValue);
	    return findByJPQLQuery(jpql.toString(), paramMap, begin, pageSize);
	  }

	  public int countAll() throws DataAccessException{
	    return countByJPQLQuery(getCountJPQL(null), null);
	  }
	  
	  public int countByWhere(String whereJPQL, Map<String, Object> paramMap) throws DataAccessException {
	    return countByJPQLQuery(getCountJPQL(whereJPQL), paramMap);
	  }
	  
	  public int countByJPQLQuery(String jpql, Map<String, Object> paramMap) throws DataAccessException {
	    return countByQuery(jpql, "JPQL", paramMap);
	  }
	  
	  public int countByNamedQuery(String queryName, Map<String, Object> paramMap) throws DataAccessException {
	    return countByQuery(queryName, "NAMED", paramMap);
	  }
	  
	  public int countByNativeQuery(String nativeSQL, Map<String, Object> paramMap) throws DataAccessException {
	    return countByQuery(nativeSQL, "NATIVE", paramMap);
	  }

	  public int countByProperty(String propertyName, Object propertyValue) throws DataAccessException {
	    String variableName = this.entity.getSimpleName().substring(0, 1).toLowerCase() + this.entity.getSimpleName().substring(1);
	    StringBuilder jpql = new StringBuilder("select count(");
	    jpql.append(variableName);
	    jpql.append(") from " + this.entity.getSimpleName() + " ");
	    jpql.append(variableName);
	    jpql.append(" where ");
	    jpql.append(variableName);
	    jpql.append("." + propertyName + "=:" + propertyName);
	    Map paramMap = new HashMap();
	    paramMap.put(propertyName, propertyValue);
	    return countByJPQLQuery(jpql.toString(), paramMap);
	  }

	  private String getSelectJPQL(String whereJPQL){
	    String variableName = this.entity.getSimpleName().substring(0, 1).toLowerCase() + this.entity.getSimpleName().substring(1);
	    StringBuilder jpql = new StringBuilder("select ");
	    jpql.append(variableName);
	    jpql.append(" from " + this.entity.getSimpleName() + " ");
	    jpql.append(variableName);
	    if ((whereJPQL != null) && (!whereJPQL.equals(""))) {
	      if (whereJPQL.startsWith(" order by"))
	        jpql.append(whereJPQL);
	      else
	        jpql.append(" where ").append(whereJPQL);
	    }
	    return jpql.toString();
	  }

	  public List<T> findByJPQLQuery(String jpql, Map<String, Object> paramMap, int begin, int pageSize) throws DataAccessException{
	    return findByQuery(jpql, "JPQL", paramMap, begin, pageSize);
	  }

	  private List<T> findByQuery(String queryString, String queryType, Map<String, Object> paramMap, int begin, int pageSize) throws DataAccessException {
		    List<T> list = new ArrayList<T>();
		    Query query = null;
		    if (queryType.equals("JPQL")){
		      query = this.entityManager.createQuery(queryString);
		    }else if (queryType.equals("NAMED")){
		      query = this.entityManager.createNamedQuery(queryString);
		    }else if (queryType.equals("NATIVE")) {
		      query = this.entityManager.createNativeQuery(queryString, this.entity);
		    }
		    boolean fullRecord = false;
		    if (paramMap != null) {
		      for (Iterator it = paramMap.entrySet().iterator(); it.hasNext(); ) {
		        Map.Entry entry = (Map.Entry)it.next();
		        if (!((String)entry.getKey()).equals("venus_fullRecord")) {
		          query.setParameter((String)entry.getKey(), entry.getValue());
		        }
		      }
		      if (paramMap.containsKey("venus_fullRecord")) fullRecord = true;
		    }
	
		    if (fullRecord) {
		      if ((begin >= 0) && (pageSize > 0)) {
		        query.setFirstResult(begin);
		        query.setMaxResults(pageSize);
		      }
		    }else {
		      if (begin >= 0) query.setFirstResult(begin);
		      if ((pageSize < 0) || (pageSize > 5000)) query.setMaxResults(5000);
		    }
		    list = query.getResultList();
		    return list;
	  }

	  private String getCountJPQL(String whereJPQL) {
	    String variableName = this.entity.getSimpleName().substring(0, 1).toLowerCase() + this.entity.getSimpleName().substring(1);
	    StringBuilder jpql = new StringBuilder("select count(");
	    jpql.append(variableName);
	    jpql.append(") from " + this.entity.getSimpleName() + " ");
	    jpql.append(variableName);
	    if ((whereJPQL != null) && (!whereJPQL.equals("")))
	      jpql.append(" where ").append(whereJPQL);
	    return jpql.toString();
	  }

	  private int countByQuery(String queryString, String queryType, Map<String, Object> paramMap) throws DataAccessException {
	    int count = 0;
	    Query query = null;
	    if (queryType.equals("JPQL"))
	      query = this.entityManager.createQuery(queryString);
	    else if (queryType.equals("NAMED"))
	      query = this.entityManager.createNamedQuery(queryString);
	    else if (queryType.equals("NATIVE")) {
	      query = this.entityManager.createNativeQuery(queryString);
	    }

	    if (paramMap != null) {
	      for (Iterator it = paramMap.entrySet().iterator(); it.hasNext(); ) {
	        Map.Entry entry = (Map.Entry)it.next();
	        query.setParameter((String)entry.getKey(), entry.getValue());
	      }
	    }

	    Long result = (Long)query.getSingleResult();
	    if (result != null) {
	      count = result.intValue();
	    }

	    return count;
	  }

	  public Integer callProcedure(String procedureName, List<Object> paramList) {
		    Query query = null;
		    ArrayList paramArray = new ArrayList();
		    if (paramList != null) {
		      for (int i = 0; i < paramList.size(); i++) {
		        paramArray.add("?");
		      }
		    }
		    String queryString = "{call " + procedureName + "(" + StringUtils.join(paramArray.toArray(), ",") + ")}";
		    query = this.entityManager.createNativeQuery(queryString, this.entity);
		    logger.info("call procedure:" + query);
		    if (paramList != null) {
		      for (int i = 0; i < paramList.size(); i++) {
		        query.setParameter(i + 1, paramList.get(i));
		      }
		    }
		    return Integer.valueOf(query.executeUpdate());
	  }

	  public boolean exists(PK id) {
		    Object updated = this.entityManager.find(this.entity, id);
		    return updated != null;
	  }
	  
	  public void flush(){
	      this.entityManager.flush();
	  }

	  public void clear(){
	      this.entityManager.clear();
	  }
	  
	  public void beginTransaction(){
		  this.entityManager.getTransaction().begin();
	  }
	  
	  public void commit(){
		  this.entityManager.getTransaction().commit();
	  }
	  
	  @SuppressWarnings("unchecked")
	  private Object setPK(Object o) {
	        Class entityClass = o.getClass();
	        Field[] fields = entityClass.getDeclaredFields();
	        for (Field f : fields) {
	            Annotation[] annotations = f.getAnnotations();
	            String name = f.getName();
	            String getMethodName = "get" + StringUtils.left(name, 1).toUpperCase() + StringUtils.substring(name, 1);
	            String setMethodName = "set" + StringUtils.left(name, 1).toUpperCase() + StringUtils.substring(name, 1);
	            Method getMethod = null;
	            Method setMethod = null;
	            try {
	                getMethod = entityClass.getDeclaredMethod(getMethodName);
	                setMethod = entityClass.getDeclaredMethod(setMethodName, f.getType());
	                if (annotations.length <= 0) {
	                    annotations = getMethod.getAnnotations();
	                }
	                for (Annotation anno : annotations) {
	                    if (anno.toString().contains("@javax.persistence.Id()")) {
	                        if (getMethod != null) {
	                            Object resultId = getMethod.invoke(o);
	                            logger.debug("对象：" + o.getClass().getTypeName() + "的id值为" + resultId); 
	                            if (f.getType().getTypeName().equals("java.lang.Long") || f.getType().getTypeName().equals("long")) {
                                    if(resultId == null) {
    	                                long id = SnowFlakeUtil.newId();
    	                                logger.debug("生成id值为：" + id);
    	                                setMethod.invoke(o, (Object) id);
    	                            }else if((Long)resultId == 0L){
    	                            	long id = SnowFlakeUtil.newId();
     	                                logger.debug("id为0，生成id值为：" + id);
     	                                setMethod.invoke(o, (Object) id);
    	                            }else {
    	                                // id不为空，不改变id的值
    	                                logger.debug("对象：" + o.getClass().getTypeName() + "的id值不为空，不改变id的值。");
    	                                return o;
    	                            }
                                }else{
                                	logger.warn("主键id对应的变量非long类型，无法回写id，类型为：" + f.getType().getTypeName());
                                    return o;
                                }
	                        }
	                    }
	                }
	            } catch (NoSuchMethodException e1) {
	                logger.error("找不到成员变量对应的set get方法！", e1);
	                continue;
	            } catch (SecurityException e1) {
	                logger.error("", e1);
	            } catch (IllegalAccessException e) {
	                logger.error("", e);
	            } catch (IllegalArgumentException e) {
	                logger.error("", e);
	            } catch (InvocationTargetException e) {
	                logger.error("", e);
	            }
	        }
	        return o;
	    }

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
		this.entityManager = SharedEntityManagerCreator.createSharedEntityManager(entityManagerFactory);
	}

	public Class<T> getEntity() {
		return entity;
	}

	public void setEntity(Class<T> entity) {
		this.entity = entity;
	} 
}
