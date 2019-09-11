package com.ninggc.platformdemo.Service.impl;

import com.ninggc.platformdemo.Service.UserService;
import com.ninggc.platformdemo.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserEntity login(String username, String token) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setToken(token);
        return userEntity;
    }
}
