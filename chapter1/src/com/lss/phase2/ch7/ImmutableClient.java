package com.lss.phase2.ch7;

import java.util.stream.IntStream;

/**
 * @author LiSheng
 * @date 2020/6/25 16:34
 */
public class ImmutableClient {
    public static void main(String[] args) {
        Person person = new Person("Alex", "Gansu");

        new UsePersonThread(person);
        IntStream.rangeClosed(0, 5).forEach(i -> {
            new UsePersonThread(person).start();
        });
    }
}
