package com.cqupt.aw;

/**
 * className Run
 * description
 *
 * @author feng
 * @version 1.0
 * @date 2019/1/18 下午9:16
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        VolatileExample example = new VolatileExample();
        MyThread writer = new MyThread(example);
        MyThreadRead reader = new MyThreadRead(example);
        writer.start();
//        Thread.sleep(100);
        reader.start();
    }
}
