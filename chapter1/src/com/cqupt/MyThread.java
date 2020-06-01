package com.cqupt;

/**
 * @author LiSheng
 * @date 2020/6/1 22:20
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        this.setName("as");
        System.out.println("My Thread");
    }
}

