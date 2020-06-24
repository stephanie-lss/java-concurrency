package com.lss.phase2.ch1;

/**
 * @author LiSheng
 * @date 2020/6/20 22:05
 * DCL(Double Check Lock)
 */
public class SingletonObject5 {
    private static volatile SingletonObject5 instance;

    private SingletonObject5() {
    }

    public static SingletonObject5 getInstance() {
        if (instance == null) {
            synchronized (SingletonObject5.class){
                if (instance == null){
                    instance = new SingletonObject5();
                }
            }
        }
        return instance;
    }
}
