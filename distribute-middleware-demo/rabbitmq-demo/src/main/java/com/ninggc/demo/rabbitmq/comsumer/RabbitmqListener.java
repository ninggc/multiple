package com.ninggc.demo.rabbitmq.comsumer;

import com.rabbitmq.client.Channel;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
@Component
public class RabbitmqListener implements ApplicationListener<ContextRefreshedEvent> {

    private final RabbitTemplate rabbitTemplate;

    @SneakyThrows
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

    }

    @SneakyThrows
    @RabbitListener(queues = "d")
    @RabbitHandler
    public void consumer(@Header(AmqpHeaders.DELIVERY_TAG) long tag, Message message, Channel channel) throws IOException {
        byte[] payload = (byte[]) message.getPayload();
        String msg = new String(payload);
        log.info("received msg {}", msg);

        channel.basicAck(tag, false);
        // Thread.sleep(1 * 1000);
    }
}
