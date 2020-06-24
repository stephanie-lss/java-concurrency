package com.cqupt.aw;

class VolatileExample {
    int a = 0;
    volatile boolean flag = false;

    public void writer() {
        flag = true; // 2
        a = 1; // 1
        System.out.println("writer" + "->" + a);
    }

    public void reader() {
        if (flag) { // 3
            int i = a; // 4
            System.out.println(i);
        }
        System.out.println("reader");
    }
}

