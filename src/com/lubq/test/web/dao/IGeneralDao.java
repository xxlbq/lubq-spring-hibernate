package com.lubq.test.web.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface IGeneralDao<T, PK extends Serializable> {

	public boolean save(T object);

	public T update(T object);

	public void delete(T object);

	public void deleteOrUpdateBySQL(String sql);

	public T find(Class<T> cls, Object obj);

	public T findReference(Class<T> cls, Object obj);

	public List<T> findList(String jpql, Class<T> cls,
			Map<Integer, Object> param);

	public List<T> findList(String jpql, Class<T> cls,
			Map<Integer, Object> param, String pageNo, String pageCount);

	public List<T> find(String sql, Class<T> cls);

	public String findStringBySql(String sql);

	public Object[] findObjectBySql(String sql);

	public List<Object[]> findObjectsBySql(String sql);

}