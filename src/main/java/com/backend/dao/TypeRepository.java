package com.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.domain.Type;

/**
 * Created by sophon on 7/12/17.
 */
public interface TypeRepository extends JpaRepository<Type, Long> {
}
