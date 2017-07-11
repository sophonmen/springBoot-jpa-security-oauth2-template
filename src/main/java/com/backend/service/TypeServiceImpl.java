package com.backend.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.dao.TypeDao;
import com.backend.domain.Type;
import com.backend.domain.TypeImpl;
import com.backend.dto.TypeDTO;
import com.backend.helper.ResponseList;

import javassist.tools.rmi.ObjectNotFoundException;

/**
 * Created by sophon on 7/8/17.
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeDao typeDao;

    public static Type convert(TypeDTO from) {
        Type to = new TypeImpl();
        to.setId(from.getId());
        to.setType(from.getType());
        return to;
    }

    public static TypeDTO convert(Type from) {
        TypeDTO to = new TypeDTO();
        to.setId(from.getId());
        to.setType(from.getType());
        return to;
    }

    public static List<TypeDTO> convert(List<Type> from) {
        if (from == null || from.size() == 0) {
            return Collections.emptyList();
        }
        List<TypeDTO> to = from.stream().map(f -> convert(f)).collect(Collectors.toList());
        return to;
    }

    @Override
    public Type save(Type type) {
        return typeDao.save(type);
    }

    @Override
    public ResponseList<TypeDTO> getAll() {
        List<TypeDTO> types = convert(typeDao.getAll());
        return new ResponseList<>(types);
    }

    @Override
    public Type findById(Long id) {
        return typeDao.findById(id);
    }

    @Override
    public Type update(Type type) {
        return typeDao.update(type);
    }

    @Override
    public Type delete(Long id) throws ObjectNotFoundException {
        return typeDao.delete(id);
    }
}
