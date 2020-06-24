package com.cqupt.innerclass;

public class OutClass {
    static class InnerClass1 {
        public void method1(innerClass2 class2) {
            String threadName = Thread.currentThread().getName();
            synchronized (innerClass2.class) {
                System.out.println(threadName + " in class1 method1");
                for (int i = 0; i < 10; i++) {
                    System.out.println("i = " + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(threadName + " out class1 method1");
            }
        }

        synchronized public void method2() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " in class1 method2");
            for (int j = 0; j < 10; j++) {
                System.out.println("j = " + j);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(threadName + " out class1 method2");
        }
    }

    static class innerClass2 {
        public void method1() {
            synchronized(innerClass2.class){
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " in class2 method1");
                for (int k = 0; k < 10; k++) {
                    System.out.println("k = " + k);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(threadName + " out class2 method1");
            }
        }
    }
}