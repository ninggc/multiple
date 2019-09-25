package com.ninggc.learning.project;

import org.springframework.context.support.AbstractRefreshableConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        AbstractRefreshableConfigApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        context.getEnvironment().setActiveProfiles("local");

    }
}
