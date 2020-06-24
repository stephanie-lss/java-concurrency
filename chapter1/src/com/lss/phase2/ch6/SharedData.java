package com.lss.phase2.ch6;

/**
 * @author LiSheng
 * @date 2020/6/24 21:53
 */
public class SharedData {
    private final char[] buffer;

    private final ReadWriterLock lock = new ReadWriterLock();

    public SharedData(int size) {
        this.buffer = new char[size];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = '*';
        }
    }

    public char[] read() {
        try {
            lock.readLock();
            return this.doRead();
        } finally {
            lock.readUnlock();
        }
    }

    private char[] doRead() {
        char[] newBuff = new char[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            newBuff[i] = buffer[i];
        }
        slowly(50);
        return newBuff;
    }

    private void slowly(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void write(char c) throws InterruptedException {
        try {
            lock.writeLock();
            this.doWrite(c);
        } finally {
            lock.writeUnlock();
        }
    }

    private void doWrite(char c) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = c;
            slowly(10);
        }
    }
}
