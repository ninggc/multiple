package com.ninggc.microuserservice.web;

import com.netflix.discovery.converters.Auto;
import com.ninggc.microuserservice.entity.UserEntity;
import com.ninggc.microuserservice.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Auto
    UserService userService;

    @GetMapping("/get/{token}")
    public List<UserEntity> getAll(@PathVariable String token) {
        return userService.getAll();
    }
}
