package com.ninggc.microuserservice.web;

import com.ninggc.microuserservice.entity.UserEntity;
import com.ninggc.microuserservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get/{token}")
    public List<UserEntity> getAll(@PathVariable String token) {
        return userService.getAll();
    }

    @PostMapping("/login")
    public UserEntity login(UserEntity user) {
        return userService.login(user.getUsername(), user.getToken());
    }
}
