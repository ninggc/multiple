package com.ninggc.nacosdemo.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RibbonDemo implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        for (int i = 0; i < 100; i++) {
            restTemplate.getForObject("http://nacos-demo/", String.class);
        }
    }
}
