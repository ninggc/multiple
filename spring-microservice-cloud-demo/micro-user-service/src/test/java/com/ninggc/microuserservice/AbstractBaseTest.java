package com.ninggc.microuserservice;

import com.google.gson.Gson;
import com.ninggc.microuserservice.service.DaoFactory;
import com.ninggc.microuserservice.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MicroUserServiceApplication.class)
public abstract class AbstractBaseTest {
    @Autowired
    protected Gson gson;

    @Autowired
    protected DaoFactory.UserDao userDao;

    @Autowired
    protected UserService userService;

    @Before
    public void before() { }

    @After
    public void after() { }
}
