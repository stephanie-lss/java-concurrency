package com.lss.phase2.ch13;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LiSheng
 * @date 2020/6/27 16:18
 */
public class ProduceThread extends Thread {
    private final MessageQueue messageQueue;

    private final static Random RANDOM = new Random(System.currentTimeMillis());

    private final static AtomicInteger counter = new AtomicInteger(0);

    public ProduceThread(MessageQueue messageQueue, int seq) {
        super("PRODUCER-" + seq);
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = new Message("Message-" + counter.getAndIncrement());
                messageQueue.put(message);
                System.out.println(Thread.currentThread().getName() + " put the " + message.getData());
                Thread.sleep(RANDOM.nextInt(1000));
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
