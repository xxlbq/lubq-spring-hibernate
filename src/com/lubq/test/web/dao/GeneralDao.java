package com.lubq.test.web.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GeneralDao <T, PK extends Serializable> implements IGeneralDao<T, PK>{
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private Class<T> type;
	
	@PersistenceContext
	private EntityManager em;
	

    /* (non-Javadoc)
	 * @see com.lubq.test.web.dao.IGeneralDao#save(T)
	 */
    public boolean save(T object){
		try {
			em.persist(object);
			return true;
		} catch (RuntimeException re) {
			logger.error("save failed", re);			
			throw re;
		}
		
    }

    /* (non-Javadoc)
	 * @see com.lubq.test.web.dao.IGeneralDao#update(T)
	 */
    public T update(T object){
		try {
			T t = em.merge(object);
			return t;
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
    }

    /* (non-Javadoc)
	 * @see com.lubq.test.web.dao.IGeneralDao#delete(T)
	 */
    public void delete(T object){
		try {
			em.remove(em.merge(object));
//			em.remove(object);
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
    }
   
    /* (non-Javadoc)
	 * @see com.lubq.test.web.dao.IGeneralDao#deleteOrUpdateBySQL(java.lang.String)
	 */
    public void deleteOrUpdateBySQL(String sql){
		try {
			Query query = em.createNativeQuery(sql);
			query.executeUpdate();
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
    }



	/* (non-Javadoc)
	 * @see com.lubq.test.web.dao.IGeneralDao#find(java.lang.Class, java.lang.Object)
	 */
	public T find(Class<T> cls,Object obj){
    	return (T)em.find(cls, obj);
    }
	
	/* (non-Javadoc)
	 * @see com.lubq.test.web.dao.IGeneralDao#findReference(java.lang.Class, java.lang.Object)
	 */
	public T findReference(Class<T> cls,Object obj){
    	return (T)em.getReference(cls, obj);
    }
	
	/* (non-Javadoc)
	 * @see com.lubq.test.web.dao.IGeneralDao#findList(java.lang.String, java.lang.Class, java.util.Map)
	 */
	public List<T> findList(String jpql,Class<T> cls,Map<Integer,Object> param){

		TypedQuery<T> query = em.createQuery(jpql,cls);
		if (null != param) {
			for(Integer keys :param.keySet()){
				query.setParameter(keys, param.get(keys)); 
			}
		}
		List<T> destList = query.getResultList();
		
    	return destList;
    }
	

	/* (non-Javadoc)
	 * @see com.lubq.test.web.dao.IGeneralDao#findList(java.lang.String, java.lang.Class, java.util.Map, java.lang.String, java.lang.String)
	 */
	public List<T> findList(String jpql,Class<T> cls,Map<Integer,Object> param,String pageNo,String pageCount){

		TypedQuery<T> query = em.createQuery(jpql,cls);
		if (null != param) {
			for(Integer keys :param.keySet()){
				query.setParameter(keys, param.get(keys)); 
			}
		}
		query.setFirstResult((Integer.valueOf(pageNo)-1)*Integer.valueOf(pageCount));   
		query.setMaxResults(Integer.valueOf(pageCount));
		List<T> destList = query.getResultList();
		
    	return destList;
    }
	

  
	/* (non-Javadoc)
	 * @see com.lubq.test.web.dao.IGeneralDao#find(java.lang.String, java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public List<T> find(final String sql,Class<T> cls){
		try {
			return ((List<T>) em.createNativeQuery(sql, cls).getResultList());
			
		} catch (RuntimeException re) {
			logger.error("select failed", re);
			throw re;
		}
    }
    
   
	/* (non-Javadoc)
	 * @see com.lubq.test.web.dao.IGeneralDao#findStringBySql(java.lang.String)
	 */
	@SuppressWarnings({ "unchecked" })
	public String findStringBySql(final String sql){
		try {
			Query queryCount = em.createNativeQuery(sql);
			List<String> list = queryCount.getResultList();
			if(list!=null&&list.size()>0){
				return list.get(0);
			}
		} catch (RuntimeException re) {
			logger.error("select failed", re);
		}
		return null;
	}
	
	

	/* (non-Javadoc)
	 * @see com.lubq.test.web.dao.IGeneralDao#findObjectBySql(java.lang.String)
	 */
	@SuppressWarnings({ "unchecked" })
	public Object[] findObjectBySql(final String sql){
		try {
			Query queryCount = em.createNativeQuery(sql);
		    List<Object []> obj = queryCount.getResultList();
		    if(obj!=null&&obj.size()>0){
		    	return obj.get(0);
		    }
		} catch (RuntimeException re) {
			logger.error("select failed", re);
		}
		return null;
    }
	
   
	/* (non-Javadoc)
	 * @see com.lubq.test.web.dao.IGeneralDao#findObjectsBySql(java.lang.String)
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Object[]> findObjectsBySql(final String sql){
		try {
			Query queryCount = em.createNativeQuery(sql);
		    return queryCount.getResultList();
		} catch (RuntimeException re) {
			logger.error("select failed", re);
		}
		return null;
    }

	protected Class<T> getObjectClass(){
		return type;
	}

}
