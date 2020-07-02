package com.lss.phase2.ch8;

/**
 * @author LiSheng
 * @date 2020/6/26 19:51
 */
public class ASynFuture<T> implements Future<T> {

    private volatile boolean done = false;

    private T resull;

    public void done(T resull) {
        synchronized (this) {
            this.resull = resull;
            this.done = true;
            this.notifyAll();
        }
    }

    @Override
    public T get() throws InterruptedException {
        synchronized (this) {
            while (!done) {
                this.wait();
            }
        }
        return resull;
    }
}
