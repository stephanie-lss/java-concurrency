package com.lss.phase2.ch1;

/**
 * @author LiSheng
 * @date 2020/6/20 22:05
 * DCL(Double Check Lock)
 */
public class SingletonObject6 {
    private static volatile SingletonObject6 instance;

    private SingletonObject6() {
    }

    private static class InstanceHolder {
        private static final SingletonObject6 instance = new SingletonObject6();
    }

    public static SingletonObject6 getInstance() {
        return InstanceHolder.instance;
    }
}
