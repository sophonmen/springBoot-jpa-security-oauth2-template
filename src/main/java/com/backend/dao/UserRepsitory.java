package com.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.domain.User;

/**
 * Created by sophon on 7/11/17.
 */
public interface UserRepsitory extends JpaRepository<User, LinkageError> {

    User findByUsername(String username);
}
