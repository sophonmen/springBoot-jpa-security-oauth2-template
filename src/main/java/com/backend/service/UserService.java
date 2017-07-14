package com.backend.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.backend.domain.User;

/**
 * Created by sophon on 7/11/17.
 */
public interface UserService {
    User save(User user);

    User findByUsername(String username);

    User findById(Long id);

    Page<User> listByPage(Pageable pageable);
    List<User> getList();

}
