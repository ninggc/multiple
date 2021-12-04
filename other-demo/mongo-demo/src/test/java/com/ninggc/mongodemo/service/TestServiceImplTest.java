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

    final String collectionName = "test";

    @Test
    void test1() {
        // testService.test();
        MongoValuePO po = new MongoValuePO(null, new HashMap<>(), null);
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

    @Test
    void testFind() {
        String id = "61718c392ba5f64b235a2201";
        ObjectId objectId = new ObjectId(id);
        List<Map> map1 = mongoTemplate.find(Query.query(Criteria.where("id").is(id)), Map.class, collectionName);
        List<Map> map2 = mongoTemplate.find(Query.query(Criteria.where("id").is(objectId)), Map.class, collectionName);
        List<Map> map3 = mongoTemplate.find(Query.query(Criteria.where("_id").is(id)), Map.class, collectionName);
        List<Map> map4 = mongoTemplate.find(Query.query(Criteria.where("_id").is(objectId)), Map.class, collectionName);

        List<MongoValuePO> map5 = mongoTemplate.find(Query.query(Criteria.where("id").is(id)), MongoValuePO.class, collectionName);
        List<MongoValuePO> map6 = mongoTemplate.find(Query.query(Criteria.where("id").is(objectId)), MongoValuePO.class, collectionName);
        List<MongoValuePO> map7 = mongoTemplate.find(Query.query(Criteria.where("_id").is(id)), MongoValuePO.class, collectionName);
        List<MongoValuePO> map8 = mongoTemplate.find(Query.query(Criteria.where("_id").is(objectId)), MongoValuePO.class, collectionName);

        Map m1 = mongoTemplate.findById(id, Map.class, collectionName);
        Map m2 = mongoTemplate.findById(objectId, Map.class, collectionName);
        MongoValuePO m3 = mongoTemplate.findById(id, MongoValuePO.class, collectionName);
        MongoValuePO m4 = mongoTemplate.findById(objectId, MongoValuePO.class, collectionName);
    }
}