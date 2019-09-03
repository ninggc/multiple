package com.ninggc.demo.dubbo.provider;

import com.ninggc.common.DemoService;

public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
