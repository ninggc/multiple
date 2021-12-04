package com.ninggc.rabbitmq.producer.demo;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author 90697
 */
@SpringBootApplication(scanBasePackages = {"com.ninggc.demo.rabbitmq.producer", "com.ninggc.demo.rabbitmq.common"})
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

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProducerApplication.class, args);
    }
}
