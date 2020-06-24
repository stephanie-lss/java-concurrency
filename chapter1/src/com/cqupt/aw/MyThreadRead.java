package com.cqupt.aw;

/**
 * @author LiSheng
 * @date 2020/6/18 16:12
 */
public class MyThreadRead extends Thread {
    VolatileExample example;

    public MyThreadRead(VolatileExample example) {
        this.example = example;
    }

    @Override
    public void run() {
        example.reader();
    }
}
