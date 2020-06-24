package com.cqupt.notifysize5;

public class ThreadA extends Thread {
    private Object lock;

    public ThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();
        synchronized (lock) {
            System.out.println("haha1");
            if (MyList.size() != 5) {
                System.out.println("wait begin " + System.currentTimeMillis());

                System.out.println("wait end " + System.currentTimeMillis());
            }
        }
    }
}