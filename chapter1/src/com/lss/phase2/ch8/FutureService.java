package com.lss.phase2.ch8;

import java.util.function.Consumer;

/**
 * @author LiSheng
 * @date 2020/6/26 19:49
 */
public class FutureService {

    public <T> Future<T> submit(final FutureTask<T> task) {
        ASynFuture synFuture = new ASynFuture();

        new Thread(() -> {
            T result = task.call();
            synFuture.done(result);
        }).start();

        return synFuture;
    }

    public <T> Future<T> submit(final FutureTask<T> task, final Consumer<T> consumer) {
        ASynFuture synFuture = new ASynFuture();

        new Thread(() -> {
            T result = task.call();
//            synFuture.done(result);
            consumer.accept(result);
        }).start();

        return synFuture;
    }
}
