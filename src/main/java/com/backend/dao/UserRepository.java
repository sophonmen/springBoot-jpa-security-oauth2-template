package com.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.domain.User;

/**
 * Created by sophon on 7/11/17.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findOne(Long id);
}
