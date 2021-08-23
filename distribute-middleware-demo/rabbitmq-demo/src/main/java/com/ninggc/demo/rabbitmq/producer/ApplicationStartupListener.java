package com.ninggc.demo.rabbitmq.producer;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
@Component
public class ApplicationStartupListener implements ApplicationListener<ContextRefreshedEvent> {

    private final RabbitTemplate rabbitTemplate;

    @SneakyThrows
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        AtomicInteger at = new AtomicInteger();

        while (true) {
            String msg = "toDirectExchange:hello " + at.getAndIncrement();
            rabbitTemplate.send("direct", "tod", new Message(msg.getBytes(), new MessageProperties()));
            log.info("send success {}", msg);
            // rabbitTemplate.convertAndSend("tod", "hello");
            Thread.sleep(1 * 1000);
        }
    }
}
