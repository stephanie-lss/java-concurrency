package com.lss.phase2.ch13;

import java.util.Random;

/**
 * @author LiSheng
 * @date 2020/6/27 16:18
 */
public class ConsumerThread extends Thread {
    private final MessageQueue messageQueue;

    private final static Random RANDOM = new Random(System.currentTimeMillis());

    public ConsumerThread(MessageQueue messageQueue, int seq) {
        super("CONSUMER-" + seq);
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = messageQueue.take();
                System.out.println(Thread.currentThread().getName() + " take the " + message.getData());
                Thread.sleep(RANDOM.nextInt(1000));
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
