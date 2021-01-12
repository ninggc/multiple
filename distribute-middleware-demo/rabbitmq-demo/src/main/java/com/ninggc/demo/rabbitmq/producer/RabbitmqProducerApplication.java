package com.ninggc.demo.rabbitmq.producer;

import com.ninggc.demo.rabbitmq.config.ConnectionConfiguration;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * @author 90697
 */
@SpringBootApplication
// @Import(ConnectionConfiguration.class)
public class RabbitmqProducerApplication {

    @Bean
    public DirectExchange direct() {
        return new DirectExchange("direct", true, false, null);
    }

    @Bean
    public Queue d() {
        return new Queue("d", true, false, false, null);
    }

    @Bean
    public Binding db() {
        return BindingBuilder.bind(d()).to(direct()).with("tod");
    }

    @Bean
    public TopicExchange topic() {
        return new TopicExchange("topic", true, false, null);
    }

    @Bean
    public Queue t() {
        return new Queue("t", true, false, false, null);
    }

    @Bean
    public FanoutExchange fanout() {
        return new FanoutExchange("fanout", true, false, null);
    }

    @Bean
    public Queue f() {
        return new Queue("f", true, false, false, null);
    }

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(RabbitmqProducerApplication.class, args);
        RabbitTemplate rabbitTemplate = context.getBean(RabbitTemplate.class);
        while (true) {
            rabbitTemplate.send("direct", "tod", new Message("toDirectExchange:hello".getBytes(), new MessageProperties()));
            // rabbitTemplate.convertAndSend("tod", "hello");
            Thread.sleep(1 * 1000);
        }
        // AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RabbitmqProducerApplication.class);
    }
}
