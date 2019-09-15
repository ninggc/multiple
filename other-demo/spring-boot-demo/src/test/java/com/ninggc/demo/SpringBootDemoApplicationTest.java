package com.ninggc.demo;

import com.ninggc.demo.service.TestService;
import com.ninggc.springmvc.entity.UserEntity;
import com.ninggc.util.morphia.dao.base.MorphiaBase;
import com.ninggc.util.morphia.dao.base.impl.MorphiaBaseImpl;
import dev.morphia.Datastore;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootDemoApplication.class)
@Component
public class SpringBootDemoApplicationTest {

//    @Autowired
//    TestService testService;
    @Autowired
    Datastore datastore;
    @Autowired
    MorphiaBase<UserEntity> morphiaBase;

    @Before
    public void NotNull() {
        Assert.assertNotNull(datastore);
    }

    @Test
    public void test1() {
        UserEntity po = new UserEntity();
        morphiaBase.save(po);
    }
}