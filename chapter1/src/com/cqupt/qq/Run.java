package com.cqupt.qq;

/**
 * className Run
 * description
 *
 * @author feng
 * @version 1.0
 * @date 2019/1/18 下午2:53
 */
public class Run {
    public static void main(String[] args) {
        MyService service1 = new MyService();
        MyService service2 = new MyService();
        MyService service3 = new MyService();
        MyService service4 = new MyService();
        MyService service5 = new MyService();
        MyThread a1 = new MyThread(service1);
        MyThread a2 = new MyThread(service2);
        MyThread a3 = new MyThread(service3);
        MyThread a4 = new MyThread(service4);
        MyThread a5 = new MyThread(service5);
        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();
    }
}
