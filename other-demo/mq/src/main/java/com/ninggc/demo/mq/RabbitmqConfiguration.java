package com.ninggc.demo.mq;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfiguration {
    @Bean
    public ConnectionFactory connectionFactory() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("wonders.ninggc.cn");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/test");
        connectionFactory.setUsername("ninggc");
        connectionFactory.setPassword("ninggc");
        return connectionFactory;
    }

    @Bean
    public Exchange directExchange() {
        return ExchangeBuilder.directExchange("st.exchange").build();
    }

    @Bean
    public Queue queue() {
        return new Queue("st.queue");
    }
}
