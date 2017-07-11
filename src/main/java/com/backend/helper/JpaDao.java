package com.backend.helper;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by sophon on 7/7/17.
 */
public abstract class JpaDao<T> implements Dao<T> {
    protected Class entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public JpaDao(Class entityClass) {
        this.entityClass = entityClass;

    }

    @Override
    public void persist(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void remove(T entity) {

    }

    @Override
    public T findById(Long id) {
        return (T) entityManager.find(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        return Collections.emptyList();
    }
}
