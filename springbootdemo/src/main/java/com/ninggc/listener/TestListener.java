package com.ninggc.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TestListener implements ApplicationListener<TestEvent> {
    @Override
    public void onApplicationEvent(TestEvent event) {
        if (event.getApplicationContext().getParent() != null) {
            System.out.println("test event");
        }
    }
}
