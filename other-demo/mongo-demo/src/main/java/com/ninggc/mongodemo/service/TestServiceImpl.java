package com.ninggc.mongodemo.service;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
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

    @Resource
    private MongoTemplate mongoTemplate;
    @Value("${mongo.collectionName}")
    private String collectionName;
    // @Resource
    // private TransactionTemplate transactionTemplate;

    @Override
    @Transactional
    public void test() {
        // transactionTemplate.execute(new TransactionCallback<Object>() {
        //     @Override
        //     public Object doInTransaction(TransactionStatus transactionStatus) {
        //         mongoTemplate.insert(new HashMap<>());
        //         return null;
        //     }
        // });

        Map<Object, Object> objectToSave = new HashMap<>();
        objectToSave.put("a", 1);
        mongoTemplate.insert(objectToSave, collectionName);

        HashMap<Object, Object> map2 = new HashMap<>();
        map2.put("map2", 1);
        mongoTemplate.insert(map2, collectionName);

        if (false) {
            throw new RuntimeException("e");
        }
    }
}
