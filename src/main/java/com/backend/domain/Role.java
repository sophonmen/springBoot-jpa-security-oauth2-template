package com.backend.domain;

/**
 * Created by sophon on 7/11/17.
 */
public interface Role {
    static final String TABLE_NAME = "roles";

    void setRole(String role);

    String getRole();

    Long getId();

    void setId(Long id);
}
