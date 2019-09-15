package com.ninggc.microuserservice.service;

import com.ninggc.microuserservice.entity.UserEntity;
import com.ninggc.util.morphia.dao.base.impl.MorphiaQueryCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@SuppressWarnings("all")
public class UserService {
    @Autowired
    DaoFactory.UserDao userDao;

    public List<UserEntity> getAll() {
        return userDao.findAll();
    }

    public UserEntity login(String username, String token) {
        if (username == null || token == null) {
            return null;
        }

        MorphiaQueryCondition condition = new MorphiaQueryCondition();
        List<UserEntity> byAND = userDao.findByAND(condition);

        if (byAND.isEmpty()) {
            return null;
        }
        UserEntity entity = byAND.get(0);
        if (token.equals(entity.getToken())) {
            return entity;
        }

        return null;
    }

    public UserEntity register(UserEntity entity) {
        return userDao.save(entity);
    }
}
