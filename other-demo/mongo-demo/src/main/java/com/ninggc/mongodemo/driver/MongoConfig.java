package com.ninggc.mongodemo.driver;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoConfig {

    public static MongoClient mongoClient;

    static {
        // Replace the uri string with your MongoDB deployment's connection string.
        // String connectionString = "mongodb+srv://<username>:<password>@<cluster-address>/test?w=majority";
        String connectionString = "mongodb://190.168.1.201/ninggc?w=majority";
        ConnectionString connString = new ConnectionString(connectionString);
        MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(connString)
            .retryWrites(true)
            .build();
        MongoClient mongoClient = MongoClients.create(settings);

        System.out.println(String.join(", ", mongoClient.listDatabaseNames()));

    }

    public static void main(String[] args) {

    }
}
