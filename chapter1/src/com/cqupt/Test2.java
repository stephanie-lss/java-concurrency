package com.cqupt;

/**
 * @author LiSheng
 * @date 2020/6/16 15:34
 */
public class Test2 {
    private volatile int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Test2 t = new Test2();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                t.setValue(1);
                System.out.println("thread1 set");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(t.getValue());
                System.out.println("thread2 get");
            }
        });
        thread1.start();
        thread2.start();
    }
}
