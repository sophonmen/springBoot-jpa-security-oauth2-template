package com.backend.domain;

import java.util.Set;

import com.backend.helper.AuditableEntity;

/**
 * Created by sophon on 7/11/17.
 */
public interface User extends AuditableEntity {
    static final String TABLE_NAME = "users";

    Long getId();

    void setId(Long id);

    void setUsername(String username);

    String getUsername();

    void setPassword(String password);

    String getPassword();

    void setRoles(Set<Role> roles);
    Set<Role> getRoles();
}

