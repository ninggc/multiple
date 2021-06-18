package com.ninggc.redissondemo;

import lombok.SneakyThrows;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@SpringBootApplication
public class RedissonDemoApplication implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	RedissonClient redissonClient;

	public static void main(String[] args) {
		SpringApplication.run(RedissonDemoApplication.class, args);
	}

	@SneakyThrows
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		RLock lock = redissonClient.getLock("l");
		// CountDownLatch countDownLatch = new CountDownLatch(1);
		//
		// new Thread(() -> {
		// 	lock.tryLock();
		// 	System.out.println("t1 get lock");
		// 	countDownLatch.countDown();
		// 	try {
		// 		while (true) {
		// 			Thread.sleep(1 * 1000);
		// 		}
		// 	} catch (InterruptedException e) {
		// 		e.printStackTrace();
		// 	} finally {
		// 		System.out.println("exit");
		// 	}
		// 	System.out.println("t1 unlock");
		// 	lock.unlock();
		// }).start();

		// countDownLatch.await();
		// while (true) {
		// 	System.out.println("t2 acquire lock: " + new SimpleDateFormat("hh:mm:ss").format(new Date()));
		// 	Thread.sleep(1 * 1000);
		// 	if (lock.tryLock()) {
		// 		Thread.sleep(1 * 1000);
		// 		try {
		// 			System.out.println("success");
		// 		} finally {
		// 			lock.unlock();
		// 		}
		// 	} else {
		// 		System.out.println("failure");
		// 	}
		// }

	}

}
