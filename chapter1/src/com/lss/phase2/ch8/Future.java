package com.lss.phase2.ch8;

/**
 * @author LiSheng
 * @date 2020/6/26 19:47
 */
public interface Future<T> {

    T get() throws InterruptedException;

}
