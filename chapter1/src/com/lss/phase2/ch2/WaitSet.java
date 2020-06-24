package com.lss.phase2.ch2;

/**
 * @author LiSheng
 * @date 2020/6/20 22:44
 */
public class WaitSet {
    private static final Object LOCK = new Object();

    private static void work() {
        synchronized (LOCK) {
            System.out.println("Begin...");
            try {
                System.out.println("Thread will coming");
                System.out.println(Thread.currentThread().getName());
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread will out.");
        }
    }

    /**
     * 1、所有的对象都会有一个wait set，用来存放调用了该对象wait方法之后进入BLOCK状态的线程
     * 2、线程被notify之后，不一定立即得到执行
     * 3、线程从wait set中被唤醒顺序不一定是 FIFO
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        new Thread(WaitSet::work).start();
//        work();
        Thread.sleep(1000);
        synchronized (LOCK) {
            System.out.println("LCOk");
            LOCK.notify();
        }
        /*IntStream.rangeClosed(1, 10).forEach(i -> new Thread(String.valueOf(i)) {
            @Override
            public void run() {
                synchronized (LOCK) {
                    try {
                        Optional.of(Thread.currentThread().getName() + " will come to wait set.").ifPresent(System.out::println);
                        LOCK.wait();
                        Optional.of(Thread.currentThread().getName() + " will leave to wait set.").ifPresent(System.out::println);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start());
        Thread.sleep(3000);
        IntStream.rangeClosed(1, 10).forEach(i -> {
            synchronized (LOCK) {
                LOCK.notify();
            }
        });*/
    }
}
