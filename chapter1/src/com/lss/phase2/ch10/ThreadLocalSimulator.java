package com.lss.phase2.ch10;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/6/27 15:09
 */
public class ThreadLocalSimulator<T> {

    private final Map<Thread, T> storage = new HashMap<>();

    public void set(T t) {
        synchronized (this) {
            Thread key = Thread.currentThread();
            storage.put(key, t);
        }
    }

    public T get() {
        Thread key = Thread.currentThread();
        T value = storage.get(key);
        return null == value ? initialValue() : value;
    }

    private T initialValue() {
        return null;
    }
}
