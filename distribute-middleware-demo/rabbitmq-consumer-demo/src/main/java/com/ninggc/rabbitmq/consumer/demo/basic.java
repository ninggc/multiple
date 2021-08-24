package com.ninggc.demo.rabbitmq.comsumer;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;

public class basic {
    @Autowired
    Channel channel;

    public void consume() throws IOException {
        channel.basicConsume("queue", false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                long deliveryTag = envelope.getDeliveryTag();
                channel.basicAck(deliveryTag, false);
            }
        });

    }

}
