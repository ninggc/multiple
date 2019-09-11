package com.ninggc.springclouddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemoApplication.class, args);
    }

    @GetMapping("")
    public String app() {
        return "spring cloud demo";
    }
}
