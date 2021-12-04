package com.ninggc.mybatisdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author ninggc
 */
@SpringBootApplication
@MapperScan("com.ninggc")
public class MybatisDemoApplication implements ApplicationListener<ContextRefreshedEvent> {

	public static void main(String[] args) {
		SpringApplication.run(MybatisDemoApplication.class, args);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		SmsMapper smsMapper = (SmsMapper) event.getApplicationContext().getBean("smsMapper");
		smsMapper.select();
		System.out.println("");
	}
}
