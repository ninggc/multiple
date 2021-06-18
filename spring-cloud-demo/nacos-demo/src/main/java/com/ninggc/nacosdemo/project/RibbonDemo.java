package com.ninggc.nacosdemo.project;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class RibbonDemo implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        for (int i = 0; i < 10; i++) {
            // restTemplate.getForObject("http://nacos-demo/", String.class);
            ServiceInstance choose = loadBalancerClient.choose("nacos-demo");
            log.info(choose.getUri().toString());
        }
    }
}
