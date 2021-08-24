package com.ninggc.demo.rabbitmq.common.model;

import com.google.gson.Gson;
import com.ninggc.demo.rabbitmq.common.model.MqEvent;
import java.nio.charset.StandardCharsets;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.AbstractMessageConverter;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.stereotype.Component;

@Component
public class ObjectJsonMessageConverter extends AbstractMessageConverter {
    static Gson gson = new Gson();

    @Override
    protected Message createMessage(Object object, MessageProperties messageProperties) {
        messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);
        return new Message(gson.toJson(object).getBytes(StandardCharsets.UTF_8), messageProperties);
    }

    @Override
    public Object fromMessage(Message message) throws MessageConversionException {
        String json = new String(message.getBody());
        return gson.fromJson(json, MqEvent.class);
    }

}
