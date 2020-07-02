package com.lss.phase3.ch7;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LiSheng
 * @date 2020/7/1 22:31
 */
public class CompareAndSetLock {
    private final AtomicInteger value = new AtomicInteger(0);
    private Thread thread;

    public void tryLock() throws MyException {
        boolean success = value.compareAndSet(0, 1);
        if (!success) {
            throw new MyException("FALSE !!");
        } else {
            thread = Thread.currentThread();
        }
    }

    public void unLock() {
        if (0 == value.get()) {
            return;
        }
        if (thread == Thread.currentThread()) {
            value.compareAndSet(1, 0);
        }
    }
}
