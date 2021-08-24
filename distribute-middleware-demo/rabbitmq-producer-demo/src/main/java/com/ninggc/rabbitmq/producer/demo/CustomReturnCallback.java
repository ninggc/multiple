package com.ninggc.demo.rabbitmq.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomReturnCallback implements ReturnCallback {

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.info("message: {}", message);
        log.info("replyCode: {}, replyText: {}, exchange: {}, routingKey: {}", replyCode, replyText, exchange, routingKey);
    }
}
