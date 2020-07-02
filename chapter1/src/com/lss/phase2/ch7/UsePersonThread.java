package com.lss.phase2.ch7;

/**
 * @author LiSheng
 * @date 2020/6/25 16:32
 */
public class UsePersonThread extends Thread {
    private Person person;

    public UsePersonThread(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " print " + person);
        }
    }
}
