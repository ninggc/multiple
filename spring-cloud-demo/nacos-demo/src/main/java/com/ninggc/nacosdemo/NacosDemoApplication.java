package com.ninggc.nacosdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * curl -X POST "http://wonders.ninggc.cn:7098/nacos/v1/cs/configs?dataId=nacos-demo.properties&group=CLOUD_DEMO_GROUP&content=useLocalCache=true"
 */
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
// @Import(RestTemplate.class)
public class NacosDemoApplication implements ApplicationListener<ContextRefreshedEvent> {

    @Value("${useLocalCache:false}")
    private Boolean useLocalCache;

    public static void main(String[] args) {
        SpringApplication.run(NacosDemoApplication.class, args);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println(useLocalCache);
    }
}
