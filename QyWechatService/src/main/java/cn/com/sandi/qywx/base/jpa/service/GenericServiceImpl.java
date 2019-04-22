package cn.com.sandi.qywx.base.jpa.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;




import org.springframework.transaction.annotation.Transactional;

import cn.com.sandi.qywx.base.jpa.dao.GenericDao;




@Transactional
public class GenericServiceImpl<T, PK extends Serializable> implements GenericService<T, PK> {

	protected GenericDao<T, PK> genericDao;

	public GenericServiceImpl(final GenericDao<T, PK> genericDao) {
		this.genericDao = genericDao;
	}

	@Transactional(readOnly = true)
	public List<T> getAll() {
		return genericDao.getAll();
	}
	
	@Transactional(readOnly = true)
	public List<T> getAllDistinct(int begin, int pageSize){
		return genericDao.getAllDistinct(begin, pageSize); 
	}
	
	@Transactional(readOnly = true)
	public List<T> getAll(int begin, int pageSize) {
		return genericDao.getAll(begin,pageSize);
	}

	@Transactional(readOnly = true)
	public T get(PK id) {
		return genericDao.get(id);
	}

	@Transactional(readOnly = true)
	public List<T> findByProperty(String propertyName, Object propertyValue,int begin, int pageSize) {
		return genericDao.findByProperty(propertyName, propertyValue,begin, pageSize);
	}
	
	@Transactional(readOnly = true)
	public List<T> findByNamedQuery(String queryName, Map<String, Object> paramMap,int begin, int pageSize){
		return genericDao.findByNamedQuery(queryName,paramMap,begin,pageSize);
	}

	@Transactional(readOnly = true)
	public List<T> findByWhere(String whereJPQL, Map<String,Object> paramMap, int begin, int pageSize){
		return genericDao.findByWhere(whereJPQL,paramMap,begin,pageSize);
	}
	
	@Transactional(readOnly = true)
	public List<T> findByNativeQuery(String nativeSQL, Map<String,Object> paramMap, int begin, int pageSize){
		return genericDao.findByNativeQuery(nativeSQL,paramMap,begin,pageSize);
	}

	
	@Transactional(readOnly = true)
	public boolean exists(PK id) {
		return genericDao.exists(id);
	}

	public T save(T object) {
		return genericDao.save(object);
	}

	public void update(T object) {
		genericDao.update(object);
	}

	public void remove(PK id) {
		genericDao.remove(id);
	}

	public int removeAll(String tableName){
		return genericDao.removeAll(tableName);
	}

	@Transactional(readOnly = true)
    public int countAll(){
    	return genericDao.countAll();
    }
	
	@Transactional(readOnly = true)
	public int countByWhere(String whereJPQL, Map<String,Object> paramMap){
		return genericDao.countByWhere(whereJPQL, paramMap);
	}

	@Transactional(readOnly = true)
	public int countByJPQLQuery(String jpql, Map<String,Object> paramMap){
		return genericDao.countByJPQLQuery(jpql, paramMap);
	}

	@Transactional(readOnly = true)
	public int countByNamedQuery(String queryName, Map<String,Object> paramMap){
		return genericDao.countByNamedQuery(queryName, paramMap);
	}

	@Transactional(readOnly = true)
	public int countByNativeQuery(String nativeSQL, Map<String,Object> paramMap){
		return genericDao.countByNativeQuery(nativeSQL, paramMap);
	}

	@Transactional(readOnly = true)
	public int countByProperty(String propertyName, Object propertyValue){
		return genericDao.countByProperty(propertyName, propertyValue);
	}

	public Integer callProcedure(String procedureName, List<Object> paramList){
	  return 	genericDao.callProcedure(procedureName, paramList);
	}

	public void flush() {
		genericDao.flush();
	}
	
	public void clear() {
		genericDao.clear();
	}

	@Override
	public int updateByWhere(String updateJPQL, String whereJPQL,Map<String, Object> paramMap) {
		return genericDao.updateByWhere(updateJPQL, whereJPQL, paramMap);
	}

	@Override
	public int deleteByWhere(String whereJPQL, Map<String, Object> paramMap) {
		return genericDao.deleteByWhere(whereJPQL, paramMap);
	}

	public GenericDao<T, PK> getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao<T, PK> genericDao) {
		this.genericDao = genericDao;
	}

	

}
