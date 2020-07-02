package com.lss.phase2.ch13;

/**
 * @author LiSheng
 * @date 2020/6/27 16:24
 */
public class PCClient {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue();
        new ProduceThread(messageQueue,1).start();
        new ProduceThread(messageQueue,2).start();
        new ProduceThread(messageQueue,3).start();
        new ConsumerThread(messageQueue,1).start();
        new ConsumerThread(messageQueue,2).start();
    }
}
