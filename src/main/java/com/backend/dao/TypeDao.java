package com.backend.dao;

import java.util.List;

import com.backend.domain.Type;

import javassist.tools.rmi.ObjectNotFoundException;

/**
 * Created by sophon on 7/8/17.
 */
public interface TypeDao {
    Type save(Type type);

    Type findById(Long id);

    List<Type> getAll();

    Type update(Type type);

    Type delete(Long id) throws ObjectNotFoundException;

    Boolean isExist(Type type);
}