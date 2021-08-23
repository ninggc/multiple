package com.ninggc.demo.rabbitmq.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

public class ConnectionConfiguration {
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost("wonders.ninggc.cn");
        connectionFactory.setVirtualHost("/test");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("ninggc");
        connectionFactory.setPassword("ninggc");
        return connectionFactory;
    }
}
