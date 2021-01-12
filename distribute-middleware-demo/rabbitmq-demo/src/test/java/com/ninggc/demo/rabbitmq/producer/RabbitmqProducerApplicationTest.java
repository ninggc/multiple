package com.ninggc.demo.rabbitmq.producer;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RabbitmqProducerApplicationTest {
    @Autowired
    ConnectionFactory connectionFactory;


    @Test
    public void directExchange() {
        System.out.println(connectionFactory.getHost());
    }

}