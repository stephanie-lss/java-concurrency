package com.cqupt;

/**
 * @author LiSheng
 * @date 2020/6/1 22:54
 */
public class LoginServlet {
    private static String usernameRef;
    private static String passwordRef;

    public static synchronized void doPost(String username, String password) {
        try {
            usernameRef = username;
            if ("a".equals(username)) {
                Thread.sleep(5000);
            }
            passwordRef = password;
            System.out.println("username=" + usernameRef + " password=" + password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
