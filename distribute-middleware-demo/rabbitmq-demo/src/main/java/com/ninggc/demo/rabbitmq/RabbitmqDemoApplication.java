package com.ninggc.demo.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Proxy;

@SpringBootApplication
public class RabbitmqDemoApplication {

    public static void main(String[] args) {
        // SpringApplication.run(RabbitmqDemoApplication.class, args);
        // AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RabbitmqConfiguration.class);
        // RabbitTemplate rabbitTemplate = context.getBean(RabbitTemplate.class);
        //
        // while (true) {
        //     rabbitTemplate.convertAndSend("", "test");
        // }
        // Proxy.newProxyInstance()
    }

}
