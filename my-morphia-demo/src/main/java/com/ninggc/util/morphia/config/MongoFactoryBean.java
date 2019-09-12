package com.ninggc.util.morphia.config;

import com.mongodb.*;
import org.springframework.beans.factory.config.AbstractFactoryBean;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class MongoFactoryBean extends AbstractFactoryBean<MongoClient> {

    /**
     * 表示服务器列表
     */
    private String[] serverStrings;

    /**
     * mongo配置对象
     */
    private MongoOptions mongoOptions;

    /**
     * 是否主从分离，默认为false
     */
    private boolean readSecondary = false;


    public String[] getServerStrings() {
        return serverStrings;
    }

    public void setServerStrings(String[] serverStrings) {
        this.serverStrings = serverStrings;
    }

    public MongoOptions getMongoOptions() {
        return mongoOptions;
    }

    public void setMongoOptions(MongoOptions mongoOptions) {
        this.mongoOptions = mongoOptions;
    }

    public WriteConcern getWriteConcern() {
        return writeConcern;
    }

    public void setWriteConcern(WriteConcern writeConcern) {
        this.writeConcern = writeConcern;
    }

    public boolean isReadSecondary() {
        return readSecondary;
    }

    public void setReadSecondary(boolean readSecondary) {
        this.readSecondary = readSecondary;
    }

    /**
     * 设定写策略，默认采用SAFE模式(需要抛异常)
     */
    private WriteConcern writeConcern = WriteConcern.SAFE;

    @Override
    public Class<?> getObjectType() {
        return MongoClient.class;
    }

    @Override
    protected MongoClient createInstance() throws Exception {
        MongoClient mongo = initMongo();

        //设定主从分离
        if (readSecondary) {
            mongo.setReadPreference(ReadPreference.secondaryPreferred());
        }
        //设定写策略
        mongo.setWriteConcern(writeConcern);
        return mongo;
    }

    /**
     * 初始化mongo
     * @return
     * @throws Exception
     */
    private MongoClient initMongo() throws Exception {
        //根据条件创建mongo实例
        MongoClient mongo = null;
        List<ServerAddress> serverList = getServerList();
        mongo = new MongoClient(serverList.get(0));
        return mongo;
    }

    /**
     * 获取mongo地址
     * @return
     */
    private List<ServerAddress> getServerList() throws Exception {
        List<ServerAddress> serverList = new ArrayList<>();
        try {
            for (String serverString: serverStrings) {
                String[] temp = serverString.split(":");
                String host = temp[0];
                if (temp.length > 2) {
                    throw new IllegalArgumentException(
                            "Invalid server address string:" + serverString
                    );
                }
                if (temp.length == 2) {
                    serverList.add(new ServerAddress(host, Integer.parseInt(temp[1])));
                } else {
                    serverList.add(new ServerAddress(host));
                }
            }
            return serverList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(
                    "Error while converting serverString to ServerAddressList", e
            );
        }
    }
}