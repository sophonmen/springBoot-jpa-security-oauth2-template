package com.backend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.domain.Type;

import javassist.tools.rmi.ObjectNotFoundException;

/**
 * Created by sophon on 7/8/17.
 */
@Transactional
@Repository
public class TypeDaoImpl implements TypeDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Type save(Type type) {
        entityManager.persist(type);
        return type;
    }

    @Override
    public Type findById(Long id) {
        return entityManager.find(Type.class, id);
    }

    @Override
    public Type delete(Long id) throws ObjectNotFoundException {
        Type type=findById(id);
        if(type==null){
            throw new ObjectNotFoundException("type not found");
        }
        entityManager.remove(type);
        return type;
    }

    @Override
    public List<Type> getAll() {
        StringBuilder query = new StringBuilder();
        query.append("FROM ");
        query.append("Type WHERE ARCHIVED !='Y'");
        return (List<Type>) entityManager.createQuery(query.toString()).getResultList();
    }

    @Override
    public Type update(Type type) {
        Type oldType = findById(type.getId());
        oldType.setType(type.getType());
        entityManager.flush();
        return type;
    }


    @Override
    public Boolean isExist(Type type) {
        return null;
    }
}