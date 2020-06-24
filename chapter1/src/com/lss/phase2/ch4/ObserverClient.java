package com.lss.phase2.ch4;

/**
 * @author LiSheng
 * @date 2020/6/24 20:40
 */
public class ObserverClient {

    public static void main(String[] args) {
        final Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        System.out.println("=================");
        subject.setState(10);

        System.out.println("=================");
        subject.setState(10);

        System.out.println("=================");
        subject.setState(15);
    }
}
