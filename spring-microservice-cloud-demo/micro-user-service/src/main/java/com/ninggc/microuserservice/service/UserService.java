package com.ninggc.microuserservice.service;

import com.ninggc.microuserservice.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@SuppressWarnings("all")
public class UserService {
    @Autowired
//    DaoFactory.UserDao userDao;

    public List<UserEntity> getAll() {
//        return userDao.findAll();
        return new ArrayList<>();
    }
}
