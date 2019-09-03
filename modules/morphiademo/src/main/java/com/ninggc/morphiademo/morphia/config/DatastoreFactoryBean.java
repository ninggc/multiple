package com.ninggc.morphiademo.morphia.config;

import com.mongodb.MongoClient;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import org.springframework.beans.factory.config.AbstractFactoryBean;


@Deprecated
public class DatastoreFactoryBean extends AbstractFactoryBean<Datastore> {
    /**
     * morphia实例，最好是单例
     */
    private Morphia morphia;

    /**
     * mongo实例，最好是单例
     */
    private MongoClient mongo;

    /**
     * 数据库名
     */
    private String dbName;

    /**
     * 用户名，可为空
     */
    private String username;

    /**
     * 密码，可为空
     */
    private String password;

    private boolean toEnsureIndexes;
    private boolean toEnsureCaps;

    @Override
    public Class<?> getObjectType() {
        return Datastore.class;
    }

    @Override
    protected Datastore createInstance() throws Exception {
        //这里的username和password可以为null，morphia对象会去处理
        Datastore datastore = morphia.createDatastore(mongo, dbName);
        if (toEnsureIndexes) {
            datastore.ensureIndexes();
        }
        if (toEnsureCaps) {
            datastore.ensureCaps();
        }
        return datastore;
    }

    public Morphia getMorphia() {
        return morphia;
    }

    public void setMorphia(Morphia morphia) {
        this.morphia = morphia;
    }

    public MongoClient getMongo() {
        return mongo;
    }

    public void setMongo(MongoClient mongo) {
        this.mongo = mongo;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isToEnsureIndexes() {
        return toEnsureIndexes;
    }

    public void setToEnsureIndexes(boolean toEnsureIndexes) {
        this.toEnsureIndexes = toEnsureIndexes;
    }

    public boolean isToEnsureCaps() {
        return toEnsureCaps;
    }

    public void setToEnsureCaps(boolean toEnsureCaps) {
        this.toEnsureCaps = toEnsureCaps;
    }
}
