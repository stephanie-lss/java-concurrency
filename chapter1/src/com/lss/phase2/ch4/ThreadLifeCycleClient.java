package com.lss.phase2.ch4;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/6/24 21:04
 */
public class ThreadLifeCycleClient {
    public static void main(String[] args) {
        new ThreadLifeCycleObserver().concurrentQuery(Arrays.asList("1", "2"));
    }
}
