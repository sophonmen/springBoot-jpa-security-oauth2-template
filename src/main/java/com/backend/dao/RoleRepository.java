package com.backend.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.backend.domain.Role;
import com.backend.helper.SecurityHelper;

/**
 * Created by sophon on 7/11/17.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {


    @Query("SELECT R FROM Role R WHERE R.id IN :ids")
    Set<Role> getRolesByIds(@Param("ids") List<Long> ids);
}
