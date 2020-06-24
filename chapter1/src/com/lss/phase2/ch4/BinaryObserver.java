package com.lss.phase2.ch4;

/**
 * @author LiSheng
 * @date 2020/6/24 20:35
 */
public class BinaryObserver extends Observer {
    public BinaryObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Binary String:"+ Integer.toBinaryString(subject.getState()));
    }
}
