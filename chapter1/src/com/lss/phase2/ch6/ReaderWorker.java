package com.lss.phase2.ch6;

/**
 * @author LiSheng
 * @date 2020/6/24 22:06
 */
public class ReaderWorker extends Thread {
    private final SharedData data;

    public ReaderWorker(SharedData data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char[] readBuff = data.read();
                System.out.println(Thread.currentThread().getName() + " reads " + String.valueOf(readBuff));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
