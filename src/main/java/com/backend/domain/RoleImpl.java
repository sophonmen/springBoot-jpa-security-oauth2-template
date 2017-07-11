package com.backend.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by sophon on 7/11/17.
 */
@Entity
@Table(name = Role.TABLE_NAME)
public class RoleImpl implements Role, Serializable {

    private static final long serialVersionUID = 3101526862227294211L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_ID")
    private Long id;

    @Column(name = "ROLE")
    private String role;

    @Override
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getRole() {
        return this.role;
    }

    @Override
    public Long getId() {
        return this.getId();
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
