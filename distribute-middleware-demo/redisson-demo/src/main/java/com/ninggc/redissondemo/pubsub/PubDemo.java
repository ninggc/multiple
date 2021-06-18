package com.ninggc.redissondemo.pubsub;

import lombok.SneakyThrows;
import org.redisson.Redisson;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.redisson.api.listener.MessageListener;

public class PubDemo {
    public static void main(String[] args) {
        RedissonClient redissonClient = Redisson.create();

        RTopic topic = redissonClient.getTopic("test");
        topic.addListener(String.class, new MessageListener<String>() {
            @Override
            public void onMessage(CharSequence channel, String msg) {
                System.out.println("msg");
            }
        });

        new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                while (true) {
                    Thread.sleep(1 * 1000);
                    topic.publish("hello");
                }
            }
        }.start();
    }
}
