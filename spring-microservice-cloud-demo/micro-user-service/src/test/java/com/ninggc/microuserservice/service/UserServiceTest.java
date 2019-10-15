package com.ninggc.microuserservice.service;

import com.ninggc.microuserservice.AbstractBaseTest;
import com.ninggc.microuserservice.entity.UserEntity;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UserServiceTest extends AbstractBaseTest {

    @Override
    public void before() {
        UserEntity register = userService.register(new UserEntity().setUsername("test").setToken("test"));
        Assert.assertNotNull(register);
    }

    @Override
    public void after() {
    }

    @Test
    public void getAll() {
        List<UserEntity> all = userService.getAll();
        Assert.assertFalse(all.isEmpty());
    }

    @Test
    public void login() {
        Assert.assertNotNull(userService.login("test", "test"));
    }
}