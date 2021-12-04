package com.ninggc.demo.rabbitmq.common.config;

import com.ninggc.demo.rabbitmq.common.model.ObjectJsonMessageConverter;
import java.util.UUID;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.ConsumerTagStrategy;
import org.springframework.amqp.support.converter.ContentTypeDelegatingMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ninggc
 * @description
 * @date 2020-09-21 16:56
 **/
@Configuration
public class RabbitmqConfiguration {

    /**
     * 简单的消息监听容器
     *
     * @return
     */
    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer(ConnectionFactory connectionFactory, ObjectJsonMessageConverter objectJsonMessageConverter) {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer(connectionFactory);
        //设置监听的队列
        simpleMessageListenerContainer.setQueues();
        //设置当前消费者1
        simpleMessageListenerContainer.setConcurrentConsumers(1);
        //最大消费者个数5
        simpleMessageListenerContainer.setMaxConcurrentConsumers(10);
        //设置签收模式
        simpleMessageListenerContainer.setAcknowledgeMode(AcknowledgeMode.AUTO);
        //设置拒绝重回队列
        simpleMessageListenerContainer.setDefaultRequeueRejected(false);
        //消费端的标签策略
        simpleMessageListenerContainer.setConsumerTagStrategy(new ConsumerTagStrategy() {
            @Override
            public String createConsumerTag(String s) {
                return UUID.randomUUID().toString() + "-" + s;
            }
        });


        //创建消息监听适配器对象
        //自己创建一个消息委托器对象
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter();

        //全局转换器
        ContentTypeDelegatingMessageConverter messageConverter = new ContentTypeDelegatingMessageConverter();
        messageConverter.addDelegate(MessageProperties.CONTENT_TYPE_JSON, objectJsonMessageConverter);
        messageListenerAdapter.setMessageConverter(messageConverter);

        simpleMessageListenerContainer.setMessageListener(messageListenerAdapter);


        return simpleMessageListenerContainer;

    }
}
