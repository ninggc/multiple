package com.ninggc.demo;

import com.ninggc.demo.aspect.Performance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootApplicationTests {

	@Autowired
	Performance performance;

	@Test
	public void contextLoads() {
		performance.perform("qwe", 123L);
	}

}
