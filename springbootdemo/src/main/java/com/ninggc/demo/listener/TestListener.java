package com.ninggc.demo.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class TestListener implements ApplicationListener<TestEvent> {
    @Override
    public void onApplicationEvent(TestEvent event) {
        System.out.println("test event");
//        if (event.getApplicationContext().getParent() != null) {
//            System.out.println("test event");
//        }
    }
}
