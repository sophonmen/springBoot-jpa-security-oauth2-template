package com.backend.helper;

import org.springframework.security.core.context.SecurityContextHolder;

import com.backend.domain.User;
import com.backend.service.UserService;
import com.backend.service.UserServiceImpl;

/**
 * Created by sophon on 7/13/17.
 */
public final class SecurityHelper {

    public static User getCurrentUser(UserService service) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = service.findByUsername(username);
        return user;
    }
}
