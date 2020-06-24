package com.lss.phase2.ch1;

/**
 * @author LiSheng
 * @date 2020/6/20 22:05
 * DCL(Double Check Lock)
 */
public class SingletonObject4 {
    private static SingletonObject4 instance;

    private SingletonObject4() {
    }

    public static SingletonObject4 getInstance() {
        if (instance == null) {
            synchronized (SingletonObject4.class){
                if (instance == null){
                    instance = new SingletonObject4();
                }
            }
        }
        return instance;
    }
}
