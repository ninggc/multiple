package com.ninggc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication(scanBasePackageClasses = {DemoApplication.class})
@RestController
//@ImportResource(locations = {"classpath:provider.xml"})
public class DemoApplication {

    @Resource
    private ConfigurableApplicationContext context;

    @GetMapping("")
    public Map<String, Object> test() throws NoSuchFieldException {
        Map<String, Object> nameType = new HashMap<>();
        Map<String, Object> nameBean = new HashMap<>();
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            nameType.put(name, context.getType(name));
            nameBean.put(name, context.getBean(name));
        }
        return nameType;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
    }

}
