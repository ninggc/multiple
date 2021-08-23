package com.ninggc.mongodemo.driver;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MongoConfigTest {

    static MongoClient mongoClient;

    @BeforeAll
    static void beforeAll() {
        // Replace the uri string with your MongoDB deployment's connection string.
        // String connectionString = "mongodb+srv://<username>:<password>@<cluster-address>/test?w=majority";
        String connectionString = "mongodb://191.168.1.201:27017/ninggc?w=majority";
        ConnectionString connString = new ConnectionString(connectionString);
        MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(connString)
            .retryWrites(true)
            .build();
        mongoClient = MongoClients.create(settings);
    }

    @Test
    void listCollections() {

        System.out.println(String.join(", ", mongoClient.listDatabaseNames()));

    }

    @Test
    void txTest() {
        ClientSession clientSession = mongoClient.startSession();
        try {
            clientSession.startTransaction();
            clientSession.commitTransaction();
        } catch (RuntimeException e) {
            clientSession.abortTransaction();
        }
    }
}