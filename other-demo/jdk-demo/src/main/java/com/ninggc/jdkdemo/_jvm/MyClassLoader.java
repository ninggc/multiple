package com.ninggc.jdkdemo._jvm;

public class MyClassLoader extends ClassLoader {
    private final String path;

    public MyClassLoader(String path) {
        this.path = path;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader myClassLoader = new MyClassLoader("C:\\Users\\90697\\Documents\\Dev\\project\\multiple\\other-demo\\jdk-demo\\src\\main\\java");
        myClassLoader.loadClass("");

    }
}
