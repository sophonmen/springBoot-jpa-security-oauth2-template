package com.backend.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.backend.domain.User;
import com.backend.service.UserService;

/**
 * Created by sophon on 7/9/17.
 */
@Controller
@RequestMapping("api/user")
public class UserController {

    @Autowired
    UserService service;

    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public ResponseEntity<Object> getMe(HttpServletRequest request) {
//        Object u = HttpServletRequest;
//        UserDetails userDetails = null;
//        if (u instanceof UserDetails) {
//            userDetails = (UserDetails) u;
//        }
//
        return new ResponseEntity<>(SecurityContextHolder.getContext().getAuthentication().getPrincipal(), HttpStatus.OK);
    }
}
