package com.lss.phase2.ch4;

/**
 * @author LiSheng
 * @date 2020/6/24 19:59
 */
public abstract class Observer {
    protected Subject subject;

    public Observer(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    public abstract void update();
}
