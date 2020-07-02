package com.lss.phase3.ch7;

/**
 * @author LiSheng
 * @date 2020/7/1 22:53
 */
public class MyException extends Exception {
    String message = null;

    public MyException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
