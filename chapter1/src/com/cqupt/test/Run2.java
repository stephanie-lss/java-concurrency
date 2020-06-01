package com.cqupt.test;

import com.cqupt.ALogin;
import com.cqupt.BLogin;

/**
 * @author LiSheng
 * @date 2020/6/1 23:00
 */
public class Run2 {
    public static void main(String[] args) {
        ALogin a = new ALogin();
        a.start();
        BLogin b = new BLogin();
        b.start();
    }
}
