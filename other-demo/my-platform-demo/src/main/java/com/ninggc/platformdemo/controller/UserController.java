package com.ninggc.platformdemo.controller;

import com.ninggc.platformdemo.Service.UserService;
import com.ninggc.platformdemo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutorService;

@RestController
@RequestMapping("/user")
public class UserController {

//    @Autowired("myThreadPool")
    ExecutorService executorService;

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public UserEntity login(@RequestBody UserEntity userEntity) {
        return userService.login(userEntity.getUsername(), userEntity.getToken());
    }
}
