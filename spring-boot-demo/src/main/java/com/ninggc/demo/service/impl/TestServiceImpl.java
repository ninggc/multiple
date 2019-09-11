package com.ninggc.demo.service.impl;

import com.ninggc.demo.listener.TestEvent;
import com.ninggc.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    ApplicationContext context;

    public void test() {
        TestEvent event = new TestEvent(context);
        context.publishEvent(event);
    }
}
