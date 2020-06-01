package com.cqupt;

/**
 * @author LiSheng
 * @date 2020/6/1 22:59
 */
public class BLogin extends Thread {
    @Override
    public void run() {
        super.run();
        LoginServlet.doPost("b", "bb");
    }
}
