package com.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.domain.Role;

/**
 * Created by sophon on 7/11/17.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
