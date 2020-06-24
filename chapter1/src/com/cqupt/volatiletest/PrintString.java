package com.cqupt.volatiletest;

/**
 * @author LiSheng
 * @date 2020/6/6 15:08
 */
public class PrintString implements Runnable {
    private boolean isContinue = true;

    public boolean isContinuePrint() {
        return isContinue;
    }

    public void setContinue(boolean aContinue) {
        isContinue = aContinue;
    }

    public void printStringMethod() {
        try {
            while (isContinue) {
                System.out.println("run printStringMethod threadName=" + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("进入run了");
        printStringMethod();
    }
}
