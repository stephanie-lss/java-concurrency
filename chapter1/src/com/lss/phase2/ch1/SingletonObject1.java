package com.lss.phase2.ch1;

/**
 * @author LiSheng
 * @date 2020/6/20 22:05
 */
public class SingletonObject1 {
    /**
     * can't lazy load
     */
    private static final SingletonObject1 instance = new SingletonObject1();

    private SingletonObject1() {
    }
    public static SingletonObject1 getInstance(){
        return instance;
    }
}
