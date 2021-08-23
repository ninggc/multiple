package com.ninggc.demo.rabbitmq.comsumer;

import com.rabbitmq.client.Channel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.Message;

/**
 * @author 90697
 */
@SpringBootApplication
@Slf4j
public class ConsumerApplication {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "d")
    @RabbitHandler
    public void consumer(Message message, Channel channel) throws IOException {
        byte[] payload = (byte[]) message.getPayload();
        log.info(new String(payload));
        channel.basicAck(1L, false);
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
        List<Integer> integers = Arrays.asList(1);
        ArrayList<Object> objects = new ArrayList<>();
        integers.toArray();
    }
}
