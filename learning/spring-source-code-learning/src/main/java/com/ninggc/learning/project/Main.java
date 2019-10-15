package com.ninggc.learning.project;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Optional;

@Configuration
@ComponentScan(basePackages = "com.ninggc")
@PropertySource(value = "classpath:db.properties")
public class Main implements ApplicationListener<ContextRefreshedEvent> {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        context.getEnvironment().setActiveProfiles("local");
        Optional.ofNullable(context).map(c -> c).orElse(null);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("Main.onApplicationEvent");
    }
}
