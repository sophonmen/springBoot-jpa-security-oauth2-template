package com.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.backend.domain.User;
import com.backend.helper.SecurityHelper;
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
    public ResponseEntity<User> getMe() {

        User user = SecurityHelper.getCurrentUser();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
