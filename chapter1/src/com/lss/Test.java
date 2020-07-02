package com.lss;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author LiSheng
 * @date 2020/6/28 16:29
 */
public class Test {
    public static void createBusyThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                while (true) // 第41行
                    ;
            }
        }, "testBusyThread");
        System.out.println(Thread.currentThread().getName() + " busy");
        thread.start();
    }
    public static void createLockThread(final Object lock) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "testLockThread");
        System.out.println(Thread.currentThread().getName() + " lock");
        thread.start();
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        createBusyThread();
        br.readLine();
        Object obj = new Object();
        createLockThread(obj);
    }
}
