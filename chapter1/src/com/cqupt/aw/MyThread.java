package com.cqupt.aw;

/**
 * className MyThread
 * description
 *
 * @author feng
 * @version 1.0
 * @date 2019/1/18 下午9:15
 */
public class MyThread extends Thread {
    private VolatileExample example;

    public MyThread(VolatileExample example) {
        this.example = example;
    }

    @Override
    public void run() {
        example.writer();
    }
}
