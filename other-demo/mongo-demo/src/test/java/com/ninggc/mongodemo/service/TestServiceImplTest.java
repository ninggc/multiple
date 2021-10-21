package com.ninggc.mongodemo.service;

import com.mongodb.client.result.UpdateResult;
import com.ninggc.mongodemo.model.MongoValuePO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Resource;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@SpringBootTest
class TestServiceImplTest {

    @Resource
    private TestService testService;
    @Resource
    private MongoTemplate mongoTemplate;

    @Test
    void test1() {
        // testService.test();
        MongoValuePO po = new MongoValuePO(null, new HashMap<>(), null);
        String collectionName = "test";
        MongoValuePO insert = mongoTemplate.insert(po, collectionName);

        String id = insert.getId();
        insert.getValue().put("field_a", 1);
        Update update = new Update();
        for (Entry<String, Object> entry : po.getValue().entrySet()) {
            update.set("value." + entry.getKey(), entry.getValue());
        }
        update.inc("version");
        Query query = Query.query(Criteria.where("id").is(id));
        UpdateResult updateResult = mongoTemplate.updateFirst(query
            , update, collectionName);

        MongoValuePO test = mongoTemplate.findById(new ObjectId(id), MongoValuePO.class, collectionName);
        Map map = mongoTemplate.findById(id, Map.class, collectionName);
        List<MongoValuePO> all = mongoTemplate.findAll(MongoValuePO.class, collectionName);

    }
}