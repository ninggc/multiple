package com.ninggc.multipledb;

import com.ninggc.multipledb.redis.RedisConfiguration;
import com.ninggc.multipledb.redis.RedisProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultipleDbApplicationTests {

    @Autowired
    ApplicationContext context;

    @Test
    public void contextLoads() {
        RedisProperties properties = context.getBean(RedisProperties.class);
        RedisConfiguration configuration = context.getBean(RedisConfiguration.class);
    }
}
