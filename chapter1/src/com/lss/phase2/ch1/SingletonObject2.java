package com.lss.phase2.ch1;

/**
 * @author LiSheng
 * @date 2020/6/20 22:05
 */
public class SingletonObject2 {
    private static SingletonObject2 instance;

    private SingletonObject2() {
    }

    public static SingletonObject2 getInstance() {
        if (instance == null) {
            instance = new SingletonObject2();
        }
        return instance;
    }
}
