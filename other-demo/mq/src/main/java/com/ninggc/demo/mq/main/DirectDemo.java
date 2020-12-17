package com.ninggc.demo.mq.main;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.BlockingQueueConsumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class DirectDemo {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("wonders.ninggc.cn");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/test");
        connectionFactory.setUsername("ninggc");
        connectionFactory.setPassword("ninggc");

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        String exchangeName = "direct.exchange";
        channel.exchangeDeclare(exchangeName, "direct");

        String queueName = "direct.queue";
        channel.queueDeclare(queueName, true, false, false, null);
        channel.queueBind(queueName, exchangeName, "direct.*");

        // new BlockingQueueConsumer()
    }
}
