package com.ninggc.jdkdemo._proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.function.Supplier;

public class JdkMain {

    public static void main(String[] args) {
        String path = "/Users/ninggc/workspace/project/multiple/other-demo/jdk-demo/src/main/generate";
        // 该设置用于输出jdk动态代理产生的类
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        A target = new A();
        Supplier instance = (Supplier) Proxy.newProxyInstance(A.class.getClassLoader()
                , new Class[]{Supplier.class}, new AInvocationHandler(target));


        instance.get();
        System.out.println("end");
    }

    public static class A implements Supplier<String> {
        @Override
        public String get() {
            return JdkMain.class.getName();
        }
    }

    public static class AInvocationHandler implements InvocationHandler {
        private final A target;

        public AInvocationHandler(A target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return method.invoke(target, args);
        }
    }


}
