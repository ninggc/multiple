package com.ninggc.mongodemo.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description: TODO
 * @author: ninggc
 * @modified By: ninggc
 * @date: Created in 2021/5/15 0:32
 * @version:v1.0
 */
@Component
public class TestServiceImpl implements TestService {

    private final MongoTemplate mongoTemplate;
    @Value("${mongo.collectionName:test1}")
    private String collectionName;

    public TestServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    @Transactional
    public void test() {
        Map<Object, Object> objectToSave = new HashMap<>();
        objectToSave.put("a", 1);
        mongoTemplate.insert(objectToSave, collectionName);

        if (false) {
            throw new RuntimeException("e");
        }
    }
}
