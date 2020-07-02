package com.lss.phase2.ch8;

/**
 * @author LiSheng
 * @date 2020/6/26 19:56
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        FutureService futureService = new FutureService();
        Future<String> future = futureService.submit(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "FINISH";
        }, System.out::println);

        System.out.println("==========");
        System.out.println("do other thing.");
        Thread.sleep(1000);
        System.out.println("==========");
    }
}
