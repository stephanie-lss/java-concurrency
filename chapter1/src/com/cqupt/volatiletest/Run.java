package com.cqupt.volatiletest;

/**
 * @author LiSheng
 * @date 2020/6/6 15:10
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        PrintString printString = new PrintString();
        new Thread(printString).start();
        System.out.println("我要停止他！ stopThread=" + Thread.currentThread().getName());
        printString.setContinue(false);
    }
}
