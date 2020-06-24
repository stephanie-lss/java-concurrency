package com.cqupt;

import java.util.Vector;

/**
 * @author LiSheng
 * @date 2020/6/16 11:35
 */
public class Test {
    private static Vector<Integer> vector = new Vector<Integer>();

    private static Object monitor = new Object();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }
            Thread removeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (monitor) {
                        for (int i = 0; i < vector.size(); i++) {
                            System.out.println("remove->" + i + "->" + vector.get(i));
                            vector.remove(i);
                        }
                    }
                }
            });
            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (monitor) {
                        for (int i = 0; i < vector.size(); i++) {
                            System.out.println("get->" + i);
                            System.out.println((vector.get(i)));
                        }
                    }
                }
            });
            removeThread.start();
            printThread.start();
//不要同时产生过多的线程， 否则会导致操作系统假死
            while (Thread.activeCount() > 20) {
                ;
            }
        }
    }
}
