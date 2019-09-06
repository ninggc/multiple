package com.ninggc.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;

@Component
public class TestEvent extends ApplicationContextEvent {
    public TestEvent(ApplicationContext source) {
        super(source);
    }
}
