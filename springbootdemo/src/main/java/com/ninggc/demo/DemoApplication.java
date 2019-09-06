package com.ninggc.demo;

import com.ninggc.listener.TestEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication(scanBasePackageClasses = {DemoApplication.class})
@RestController
//@ImportResource(locations = {"classpath:provider.xml"})
public class DemoApplication implements ApplicationListener<ContextRefreshedEvent> {

    @GetMapping("")
    public Map<String, Object> test() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "spring boot");
        return map;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("app start");
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
