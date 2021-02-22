package com.ninggc.nacosdemo.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RibbonDemo implements ApplicationListener<ContextStartedEvent> {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        for (int i = 0; i < 100; i++) {
            restTemplate.getForObject("http://10.1.192.111", String.class);
        }
    }
}
