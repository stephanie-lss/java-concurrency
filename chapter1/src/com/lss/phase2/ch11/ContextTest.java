package com.lss.phase2.ch11;

import java.util.stream.IntStream;

/**
 * @author LiSheng
 * @date 2020/6/27 15:30
 */
public class ContextTest {
    public static void main(String[] args) {
        IntStream.range(0, 100).forEach(i -> {
            new Thread(new ExecutionTask()).start();
        });
    }
}
