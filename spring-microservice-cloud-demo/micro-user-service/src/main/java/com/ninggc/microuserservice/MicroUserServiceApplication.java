package com.ninggc.microuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@PropertySource("classpath:morphia/morphia.properties")
public class MicroUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroUserServiceApplication.class, args);
    }
}
