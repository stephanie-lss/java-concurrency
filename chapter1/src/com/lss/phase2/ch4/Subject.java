package com.lss.phase2.ch4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/6/24 19:56
 */
public class Subject {

    private List<Observer> Observers = new ArrayList<>();

    private int state;

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        if (state != this.state) {
            this.state = state;
            notifyAllObserver();
        }
    }

    public void attach(Observer observer) {
        Observers.add(observer);
    }

    private void notifyAllObserver(){
        Observers.forEach(Observer::update);
    }
}
