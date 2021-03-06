package com.cqupt.innerclass;

public class Run {
    public static void main(String[] args) {
        final OutClass.InnerClass1 in1 = new OutClass.InnerClass1();
        final OutClass.innerClass2 in2 = new OutClass.innerClass2();
        final OutClass.innerClass2 in3 = new OutClass.innerClass2();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                in1.method1(in2);
            }
        }, "T1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                in1.method2();
            }
        }, "T2");
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                in3.method1();
            }
        }, "T3");
        t1.start();
        t2.start();
        t3.start();
    }
}