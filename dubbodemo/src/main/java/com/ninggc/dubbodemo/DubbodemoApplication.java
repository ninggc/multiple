package com.ninggc.dubbodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DubbodemoApplication {

	@GetMapping("")
	public String app() {
	    return "app";
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DubbodemoApplication.class, args);

//		DemoService demoService = (DemoService)context.getBean("demoService"); // 获取远程服务代理
//		String hello = demoService.sayHello("world"); // 执行远程方法
//		System.out.println( hello ); // 显示调用结果
	}

}
