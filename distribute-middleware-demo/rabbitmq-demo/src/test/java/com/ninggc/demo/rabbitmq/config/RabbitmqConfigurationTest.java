package com.ninggc.demo.rabbitmq.config;

import com.rabbitmq.client.*;
import org.junit.Test;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

import java.io.IOException;
import java.util.Arrays;

public class RabbitmqConfigurationTest {
    public Connection getConnection() {
        return new ConnectionConfiguration().connectionFactory().createConnection();
    }

    @Test
    public void producer() throws IOException {
        Channel channel = getConnection().createChannel(false);
        channel.exchangeDeclare("direct", BuiltinExchangeType.DIRECT, true);
        channel.queueDeclare("d1", true, false, false, null);
        channel.queueBind("d1", "direct", "tod1");

        channel.basicPublish("direct", "tod1", false, null, "test1".getBytes());
    }

    @Test
    public void consumer() throws IOException, InterruptedException {
        Channel channel = getConnection().createChannel(false);
        DefaultConsumer callback = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                System.out.println("received msg: " + new String(body));
            }
        };
        channel.basicConsume("d1", true, callback);
        while (true) {
            // callback.
            Thread.sleep(1 * 1000);
        }

    }

}