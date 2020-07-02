package com.lss.phase3.ch3;

import java.lang.reflect.InvocationTargetException;

/**
 * @author LiSheng
 * @date 2020/7/1 12:50
 */
public class MyClassLoaderTest2 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyClassLoader classLoader1 = new MyClassLoader("MyClassLoader - 1");
        MyClassLoader classLoader2 = new MyClassLoader("MyClassLoader - 2");
        classLoader2.setDir("F:\\app\\classloader2");
        Class<?> aClass = classLoader2.loadClass("com.lss.phase3.ch3.MyObject");
        System.out.println(aClass);
        MyClassLoader myClassLoader = (MyClassLoader) aClass.getClassLoader();
        System.out.println(myClassLoader.getClassLoaderName());
    }
}
