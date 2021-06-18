package com.ninggc.multipledb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MultipleDbApplication {
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(MultipleDbApplication.class, args);
//        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

    }
}
