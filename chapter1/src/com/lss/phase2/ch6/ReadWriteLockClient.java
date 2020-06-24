package com.lss.phase2.ch6;

/**
 * @author LiSheng
 * @date 2020/6/24 22:08
 */
public class ReadWriteLockClient {
    public static void main(String[] args) {
        final SharedData data = new SharedData(10);
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        new WriterWorker(data,"qwertyuiopasdfg").start();
        new WriterWorker(data,"QWERTYUIOPASDFG").start();
    }
}
