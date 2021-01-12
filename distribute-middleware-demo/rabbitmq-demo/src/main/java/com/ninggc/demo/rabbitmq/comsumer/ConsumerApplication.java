package com.ninggc.demo.rabbitmq.comsumer;

import com.ninggc.demo.rabbitmq.config.ConnectionConfiguration;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.Message;

/**
 * @author 90697
 */
@SpringBootApplication
@Import(ConnectionConfiguration.class)
@Slf4j
public class ConsumerApplication {
    @RabbitListener(queues = "d")
    @RabbitHandler
    public void consumer(Message message, Channel channel) {
        byte[] payload = (byte[]) message.getPayload();
        log.info(new String(payload));
        // channel.basicAck();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
