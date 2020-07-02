package com.lss.phase3.ch5;

/**
 * @author LiSheng
 * @date 2020/7/1 16:03
 */
public class Namespace {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = Namespace.class.getClassLoader();
        Class<?> aClass = classLoader.loadClass("java.lang.String");
        Class<?> bClass = classLoader.loadClass("java.lang.String");
        System.out.println(aClass.hashCode());
        System.out.println(bClass.hashCode());
    }
}
