package com.lss.phase3.ch7;

/**
 * @author LiSheng
 * @date 2020/7/1 22:07
 */
public class AtomicIntegerDetailsTest {

    private final static CompareAndSetLock lock = new CompareAndSetLock();


    public static void main(String[] args) {
        //get and add
//        AtomicInteger getAndAdd = new AtomicInteger(10);
//
//        int result = getAndAdd.getAndAdd(10);
//        System.out.println(result);
//        System.out.println(getAndAdd.get());
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    doSomething();
                } catch (MyException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private static void doSomething() throws MyException, InterruptedException {
        try {
            lock.tryLock();
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(100000L);
        } finally {
            lock.unLock();
        }
    }
}
