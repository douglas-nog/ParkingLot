package br.com.dwn.smartcities.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.dwn.smartcities.dao.GenericDAO;

public class GenericDAOImpl<T, K> implements GenericDAO<T, K> {

	@PersistenceContext
	protected EntityManager em;

	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
		clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void create(T entity) {
		em.persist(entity);

	}

	@Override
	public T read(K id) {
		return em.find(clazz, id);
	}

	@Override
	public void update(T entity) {
		em.merge(entity);

	}

	@Override
	public void delete(K id) throws Exception {
		T entity = read(id);
		if (entity == null) {
			throw new Exception("Entity not found");
		}
		em.remove(entity);
	}

	@Override
	public List<T> listAll() {
		return em.createQuery("From " + clazz.getName(), clazz).getResultList();
	}

}
