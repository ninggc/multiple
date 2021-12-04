package com.ninggc.rabbitmq.producer.demo;

import com.ninggc.demo.rabbitmq.common.model.MqEvent;
import com.ninggc.demo.rabbitmq.common.model.ObjectJsonMessageConverter;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
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
    private final CustomConfirmCallback customConfirmCallback;
    private final CustomReturnCallback customReturnCallback;
    private final ObjectJsonMessageConverter objectJsonMessageConverter;

    @SneakyThrows
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        long l = System.currentTimeMillis();
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback(customConfirmCallback);
        rabbitTemplate.setReturnCallback(customReturnCallback);
        rabbitTemplate.setMessageConverter(objectJsonMessageConverter);

        for (int i = 0; i < 5; i++) {
            String msg = "toDirectExchange:hello " + l;
            // rabbitTemplate.send("direct", "-tod", new Message(msg.getBytes(), new MessageProperties()));
            rabbitTemplate.convertAndSend("direct", "tod", new MqEvent(LocalDateTime.now()));
            log.info("send success {}", msg);
            // rabbitTemplate.convertAndSend("tod", "hello");
            Thread.sleep(1 * 1000);
        }
    }
}
