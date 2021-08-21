package com.ninggc.mongodemo.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestServiceImplTest {

    @Resource
    private TestService testService;

    @Test
    void test1() {
        testService.test();
    }
}