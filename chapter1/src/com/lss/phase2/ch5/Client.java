package com.lss.phase2.ch5;

/**
 * @author LiSheng
 * @date 2020/6/24 21:22
 */
public class Client {
    public static void main(String[] args) {
        Gate gate = new Gate();
        User bj = new User("Baby", "Beijing", gate);
        User sh = new User("ShangLao", "Shanghai", gate);
        User gz = new User("GuangLao", "Guangzhou", gate);
        bj.start();
        sh.start();
        gz.start();
    }
}
