package com.backend.service;

import java.util.List;
import java.util.Set;

import com.backend.domain.Role;

/**
 * Created by sophon on 7/11/17.
 */
public interface RoleService {
    Role save(Role role);

    Set<Role> findByIds(List<Long> ids);

    List<Long> getRoleIdsFromRole(Set<Role> roles);
}
