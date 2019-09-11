package com.ninggc.springcloudclientdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackageClasses = SpringCloudClientDemoApplication.class)
@EnableEurekaClient
@RestController
public class SpringCloudClientDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudClientDemoApplication.class, args);
    }

    @GetMapping
    public String app() {
        return "";
    }

}
