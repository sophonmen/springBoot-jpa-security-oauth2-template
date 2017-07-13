package com.backend.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import com.backend.domain.User;
import com.backend.service.UserService;

/**
 * Created by sophon on 7/13/17.
 */
public class SecurityHelper {
    @Autowired
    private static UserService service;

    public static User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = service.findByUsername(username);
        return user;
    }
}
