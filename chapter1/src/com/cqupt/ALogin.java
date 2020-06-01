package com.cqupt;

/**
 * @author LiSheng
 * @date 2020/6/1 22:59
 */
public class ALogin extends Thread {
    @Override
    public void run() {
        super.run();
        LoginServlet.doPost("a", "aa");
    }
}
