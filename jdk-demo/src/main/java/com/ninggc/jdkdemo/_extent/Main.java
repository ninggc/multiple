package com.ninggc.jdkdemo._extent;

public class Main {
    public static void main(String[] args) {
        Parent base = new Child();
        int it = base.getIt();
        int i = Child.i;
        int i1 = Parent.i;
    }
}
