package com.march.blog.web;

import com.march.blog.persistence.UserEntity;
import com.march.blog.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("users")
    public Iterable<UserEntity> getUsers() {
        return userRepository.findAll();
    }
}
