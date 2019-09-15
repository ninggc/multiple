package com.ninggc.microuserservice.service;

import com.ninggc.microuserservice.entity.UserEntity;
import com.ninggc.util.morphia.dao.base.MorphiaBase;
import com.ninggc.util.morphia.dao.base.impl.MorphiaBaseImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
public interface DaoFactory {
    interface UserDao extends MorphiaBase<UserEntity> { }

    @Service
    class UserDaoImpl extends MorphiaBaseImpl<UserEntity> implements  UserDao { }
}
