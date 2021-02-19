package com.ninggc.jdkdemo._proxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibMain {
    public static void main(String[] args) {
        String path = "/Users/ninggc/workspace/project/multiple/other-demo/jdk-demo/src/main/generate";
        // 该设置用于输出cglib动态代理产生的类
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, path);
        // 该设置用于输出jdk动态代理产生的类
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(CglibMain.class.getClassLoader());
        enhancer.setSuperclass(CglibMain.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("");
                return o;
            }
        });
        CglibMain o = (CglibMain) enhancer.create();
        System.out.println("end");
    }
}
