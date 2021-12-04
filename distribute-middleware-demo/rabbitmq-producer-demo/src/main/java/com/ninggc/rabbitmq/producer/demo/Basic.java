package com.ninggc.rabbitmq.producer.demo;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

public class Basic {
    @Autowired
    Channel channel;

    /**
     * 事务模式
     */
    public void publish() {
        try {
            channel.txSelect();
            channel.basicPublish("exchange", "routingKey", null, "body".getBytes());
            channel.txCommit();
        } catch (IOException e) {
            try {
                channel.txRollback();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }

    /**
     * 同步confirm
     */
    public void publish2() {
        try {
            channel.confirmSelect();
            channel.basicPublish("exchange", "routingKey", null, "body".getBytes());
            channel.waitForConfirms();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 异步confirm
     */
    public void asyncConfirm() {
        try {
            channel.confirmSelect();
            channel.addConfirmListener(new ConfirmListener() {
                @Override
                public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                    // 成功确认
                }

                @Override
                public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                    // 失败重发
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void priorityQueue() throws IOException {
        Map<String, Object> args = new HashMap<>();
        args.put("x-max-priority", 10);
        channel.queueDeclare("priority", true, false, false, args);

        AMQP.BasicProperties.Builder builder = new AMQP.BasicProperties.Builder();
        builder.priority(5);
        channel.basicPublish("exchange", "routingKey", builder.build(), "body".getBytes());
    }
}
