package com.cqupt.notifysize5;

public class Run {
    public static void main(String[] args) {
        /**
         * notify方法执行后，并不立即释放锁
         * 每个对象都实现了wait和notify方法，他们必须用在被synchronized同步的对象临界区内
         * 通过调用wait()方法可以使处于临界区类的线程进入等待状态。同时释放被同步对象的锁
         * notify操作可以随机唤醒 等待队列中 一个因调用了wait操作而处于阻塞状态的线程，使其进入就绪状态。
         * 被重新唤醒的线程会视图重新获取临界区的控制权，也就是锁，并继续执行临界区内wait之后的代码。
         *
         * 另外：如果发出notify操作的时候，没有阻塞的进程，那么该命令会被忽略。
         *      notifyAll可以使所有等待队列中等待同一共享资源的全部线程从等待状态退出，进入可运行状态。
         *      此时优先级最高的那个线程最先执行，但也有可能是随机执行，因为这个取决于JVM虚拟机的实现。
         */
        Object lock1 = new Object();

        ThreadA aThread = new ThreadA(lock1);
        ThreadB bThread = new ThreadB(lock1);
        aThread.start();
        bThread.start();
    }
}