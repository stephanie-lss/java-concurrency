package com.cqupt.test;

import com.cqupt.MyThread;

/**
 * @author LiSheng
 * @date 2020/6/1 22:21
 */
public class Run {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();;
        System.out.println("运行结束!");
    }
}
