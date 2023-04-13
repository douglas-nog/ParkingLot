package br.com.dwn.smartcities.dao;

import java.util.List;

public interface GenericDAO<T, K> {

	void create(T entity);
	
	T read(K id);
	
	void update(T entity);
	
	void delete(K id) throws Exception;
	
	List<T> listAll();
}
