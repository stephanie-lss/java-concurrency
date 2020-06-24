package com.cqupt.test2;

/**
 * @author LiSheng
 * @date 2020/6/6 15:20
 */
public class RunThread extends Thread {
    private static boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public void run() {
        System.out.println("已经进入run了");
        while (isRunning) {

        }
        System.out.println("线程被停止了");
    }
}
