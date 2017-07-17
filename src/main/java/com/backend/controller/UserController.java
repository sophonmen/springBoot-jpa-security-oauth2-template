package com.backend.controller;

import java.util.List;
import java.util.Set;

import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.backend.domain.Role;
import com.backend.domain.User;
import com.backend.helper.SecurityHelper;
import com.backend.service.RoleService;
import com.backend.service.UserService;

/**
 * Created by sophon on 7/9/17.
 */
@Controller
@RequestMapping("api/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService service;
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public ResponseEntity<User> getMe() {
        User user = SecurityHelper.getCurrentUser(service);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> save(@RequestBody User user) {
        Set<Role> roles = roleService.findByIds(roleService.getRoleIdsFromRole(user.getRoles()));
        user.setRoles(roles);
        service.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getDetail(@PathVariable Long id) {
        User user = service.findById(id);
        if (user == null) {
            throw new ObjectNotFoundException(User.class, "User not found");
        }
        logger.debug("get user id debug :" + user.getId());
        logger.error("get user id error :" + user.getId());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Page<User>> getUsers(@RequestParam(name = "size", required = false, defaultValue = "10") int size,
                                               @RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        return new ResponseEntity<>(service.listByPage(new PageRequest(page, size)), HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>> getList() {
        logger.error("get list :" + service.getList().size());
        return new ResponseEntity<>(service.getList(), HttpStatus.OK);
    }
}
