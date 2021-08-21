package com.ninggc.mongodemo;

import com.ninggc.mongodemo.service.TestService;
import javax.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class MongoDemoApplication implements ApplicationListener<ApplicationStartedEvent> {

    @Resource
    private MongoTemplate mongoTemplate;
    @Resource
    private TestService testService;

    public static void main(String[] args) {
        SpringApplication.run(MongoDemoApplication.class, args);
    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        testService.test();
    }
}
