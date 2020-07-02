package com.lss.phase3.ch6;

/**
 * @author LiSheng
 * @date 2020/7/1 16:49
 */
public class ThreadContextClassLoader {
    public static void main(String[] args) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);
    }
}
