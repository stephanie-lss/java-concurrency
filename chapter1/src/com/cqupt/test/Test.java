package com.cqupt.test;

/**
 * @author LiSheng
 * @date 2020/6/5 20:43
 */
public class Test {
    static int i = 1;
    static {
        i = 0; // 给变量复制可以正常编译通过
    }

    public static void main(String[] args) {
        System.out.println(i);
    }
}