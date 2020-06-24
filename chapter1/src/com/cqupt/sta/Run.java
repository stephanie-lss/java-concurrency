package com.cqupt.sta;

/**
 * @author LiSheng
 * @date 2020/6/11 21:17
 */
class MyThread1 extends Thread {
    public MyThread1() {
        System.out.println("状态：" + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run方法中的状态：" + Thread.currentThread().getName());
    }
}

public class Run {
    public static void main(String[] args) {
        MyThread1 t = new MyThread1();
        t.run();
    }
}
