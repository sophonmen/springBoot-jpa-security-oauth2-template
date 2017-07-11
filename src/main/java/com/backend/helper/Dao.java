package com.backend.helper;

import java.util.List;

/**
 * Created by sophon on 7/7/17.
 */
public interface Dao<E> {
    void persist(E entity);

    void remove(E entity);

    E findById(Long id);

    List<E> findAll();
}
