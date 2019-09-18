package com.ninggc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.RequestHandledEvent;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication(scanBasePackages = {"com.ninggc"})
@RestController
@PropertySource("classpath:morphia/morphia.properties")
public class SpringBootDemoApplication implements ApplicationListener<RequestHandledEvent> {

    @Autowired
    AbstractApplicationContext context;

    @GetMapping("")
    public Map<String, Object> test() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "spring boot");
        return map;
    }

    @GetMapping("/beans")
    public Map<String, Object> beans() {
        Map<String, Object> map = new HashMap<>();
        String[] names = context.getBeanDefinitionNames();
        map.put("name", "spring boot");
        for (String name : names) {
            map.put(name, "");
        }
        return map;
    }

    @Override
    public void onApplicationEvent(RequestHandledEvent event) {
//        System.out.println("app start");
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

}
