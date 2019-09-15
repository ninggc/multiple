package com.ninggc.util.morphia.dao.base.impl;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.InsertManyOptions;
import com.ninggc.util.morphia.dao.base.MorphiaBase;
import com.ninggc.util.morphia.domain.IMorphiaPO;
import dev.morphia.Datastore;
import dev.morphia.query.FindOptions;
import dev.morphia.query.Query;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class MorphiaBaseImpl<T extends IMorphiaPO> implements MorphiaBase<T> {
    @Resource
    private Datastore datastore;

    /**
     * 事务操作说明
     * 由于morphia还没有原生的事务支持（请看morphia包下的README.md）
     * 所以需要用到mongoClient
     * 请不要在非事务的情况下使用
     * 相关操作参考链接如下
     * https://docs.mongodb.com/v4.0/core/transactions/
     * https://docs.mongodb.com/manual/core/transactions/
     */
//    以下三个字段是为事务操作准备的，请不要滥用
    @Value("${mongodb.db}")
    private String dbName;
    @Value("${mongodb.collection}")
    private String dbCollectionName;
    @Value("${mongodb.uri}")
    private String mongodbUri;

    // 导入的 T 的类的类型,通过构造类装载
    private Class<T> clazz;

    @SuppressWarnings("unchecked")
    public MorphiaBaseImpl() {
        this.clazz = (Class<T>) ((ParameterizedType) super.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T save(T po) {
        datastore.save(po);
        return po;
    }

    /**
     * 对于morphia的merge操作
     * po的id为null会报MappingException
     * 找不到匹配的id会报UpdateException
     * @param po 需要持久化的实体类
     * @return 持久化后的类
     */
    @Override
    public T update(T po) {
        datastore.merge(po);
        return po;
    }

    /**
     * 根据id找到数据
     * @param id 实体类的主键 id 需要是ObjectId类型
     * @return null if not found
     */
    @Override
    public T get(Serializable id) {
        return datastore.createQuery(clazz).field("id").equal(id).first();
    }

    @Override
    public List<T> findAll() {
        return datastore.createQuery(clazz).find().toList();
    }

    /**
     * pageNumber 查询第几页
     * pageSize 每页显示几条 默认十条
     * @param pageNumber 需要查询第几页
     * @return
     */
    @Override
    public List<T> findAll(int pageNumber) {
        //List<T> list = datastore.createQuery(clazz).asList(
        //          new FindOptions().skip(pageNumber > 0 ?((pageNumber-1)*10) : 0).limit(10));
        return findAll(pageNumber, 10);
    }


    /**
     * @param pageNumber 需要查询第几页
     * @param pageSize   每页包含多少条记录
     * @return
     */
    @Override
    public List<T> findAll(int pageNumber, int pageSize) {
        Query<T> query = datastore.createQuery(clazz);
        return query.find(new FindOptions().skip(pageNumber > 0 ? ((pageNumber - 1) * pageSize) : 0).limit(pageSize))
                .toList();
    }

    /**
     * @param queryCondition 查询条件设置
     * @return
     */
    @Override
    public List<T> findByAND(MorphiaQueryCondition queryCondition) {
        Query<T> query = datastore.createQuery(clazz);
        if (null != queryCondition) {
            query = queryCondition.andCriteria(query);
        }
        return query.find().toList();
    }


    @Override
    public List<T> findByAND(int pageNumber, MorphiaQueryCondition queryCondition) {
        return findByAND(pageNumber, 10, queryCondition);
    }

    @Override
    public List<T> findByAND(int pageNumber, int pageSize, MorphiaQueryCondition queryCondition) { 
        return null;
    }

    @Override
    public Object findByANDWithStatistic(MorphiaQueryCondition queryCondition) {
        return null;
    }

    //--
    /**
     * 使用查询对象 QueryCondition 进行 OR 查询
     * @param queryCondition 查询对象
     * @return 查询结果
     */
    @Override
    public List<T> findByOR(MorphiaQueryCondition queryCondition) {
        Query<T> query = datastore.createQuery(clazz);
        if (null != queryCondition){
            query = queryCondition.orCriteria(query);
        }
        return query.find().toList();
    }

    /**
     *
     * @param pageNumber     需要查询第几页
     * @param queryCondition 查询对象
     * @return
     */
    @Override
    public List<T> findByOR(int pageNumber, MorphiaQueryCondition queryCondition) {

        return findByOR(pageNumber, 10, queryCondition);
    }

    /**
     * 实现分页逻辑
     * @param pageNumber     需要查询第几页
     * @param pageSize       每页包含多少条记录
     * @param queryCondition 查询对象
     * @return
     */
    @Override
    public List<T> findByOR(int pageNumber, int pageSize, MorphiaQueryCondition queryCondition) {
        Query<T> query = datastore.createQuery(clazz);
        return query.find(new FindOptions().skip(pageNumber > 0 ? ((pageNumber - 1) * pageSize) : 0).limit(pageSize))
                .toList();
    }

    //--

    @Override
    public Object findByORWithStatistic(MorphiaQueryCondition queryCondition) {
        return null;
    }

    /**
     * 将PO转到mongodb原生的Document
     * @return
     */
    private List<Document> posToDocuments(List<T> pos) {
        List<Document> list = new ArrayList<>();
        for (T po : pos) {
            Document document = po.toDocument();
            list.add(document);
        }
        return list;
    }

    @Override
    public void saveList(List<T> pos) throws MongoException {
        final MongoClient client = MongoClients.create(mongodbUri);

        MongoCollection<Document> collection = client.getDatabase(dbName).getCollection(dbCollectionName);
        List<Document> documents = posToDocuments(pos);
        collection.insertMany(documents, new InsertManyOptions());
    }
}
