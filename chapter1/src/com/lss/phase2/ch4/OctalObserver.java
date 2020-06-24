package com.lss.phase2.ch4;

/**
 * @author LiSheng
 * @date 2020/6/24 20:36
 */
public class OctalObserver extends Observer {
    public OctalObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Octal String:"+ Integer.toOctalString(subject.getState()));
    }
}
