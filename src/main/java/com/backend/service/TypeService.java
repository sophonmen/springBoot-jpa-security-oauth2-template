package com.backend.service;

import java.util.List;

import com.backend.domain.Type;
import com.backend.helper.ResponseList;
import com.backend.dto.TypeDTO;

import javassist.tools.rmi.ObjectNotFoundException;

/**
 * Created by sophon on 7/8/17.
 */
public interface TypeService {

    Type save(Type type);

    Type findById(Long id);

    Type update(Type type);

    Type delete (Long id) throws ObjectNotFoundException;

    List<TypeDTO> getAll();
}


