package com.ninggc.platformdemo.Service;

import com.ninggc.platformdemo.entity.UserEntity;

public interface UserService {
    UserEntity login(String username, String token);
}
