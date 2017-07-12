package com.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.dao.RoleRepository;
import com.backend.domain.Role;

/**
 * Created by sophon on 7/11/17.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;

    @Override
    public Role save(Role role) {
        return repository.save(role);
    }
}
