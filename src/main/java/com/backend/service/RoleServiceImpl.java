package com.backend.service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Override
    public List<Long> getRoleIdsFromRole(Set<Role> roles) {
        if (roles != null && roles.size() == 0) {
            return Collections.emptyList();
        }
        return roles.stream().map(r -> r.getId()).collect(Collectors.toList());
    }

    @Override
    public Set<Role> findByIds(List<Long> ids) {
        return repository.getRolesByIds(ids);
    }
}
