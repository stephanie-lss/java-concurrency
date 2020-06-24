package com.lss.phase2.ch1;

/**
 * @author LiSheng
 * @date 2020/6/20 22:35
 */
public class SingletonObject7 {
    private SingletonObject7() {
    }

    private enum Singleton {
        INSTANCE;

        private final SingletonObject7 instance;

        Singleton() {
            instance = new SingletonObject7();
        }

        public SingletonObject7 getInstance() {
            return instance;
        }
    }

    public static SingletonObject7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        Thread[] thread = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(() -> {
                System.out.println(SingletonObject7.getInstance());
            });
            thread[i].start();
        }
    }
}
