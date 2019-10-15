package com.ninggc.microuserservice.dao;

import com.ninggc.microuserservice.MicroUserServiceApplication;
import com.ninggc.microuserservice.entity.UserEntity;
import com.ninggc.microuserservice.service.DaoFactory;
import com.ninggc.util.autogenerate.AutoGeneration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = MicroUserServiceApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class FactoryTest {

    @Autowired
    DaoFactory.UserDao userDao;

    @Test
    public void userDao() {
        UserEntity userEntity = AutoGeneration.genInstance(UserEntity.class);
        UserEntity save = userDao.save(userEntity);
        System.out.println(save.toString());
    }
}