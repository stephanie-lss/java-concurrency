package com.cqupt.pip;

import java.io.IOException;
import java.io.PipedInputStream;

public class ReadData {
    public void readMethod(PipedInputStream in) {
        try {
            System.out.println("read : ");
            byte[] bytes = new byte[20];
            int length = in.read(bytes);
            while (length != -1) {
                String newData = new String(bytes, 0, length);
                System.out.print(newData + "$$");
                length = in.read(bytes);
            }
            System.out.println();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}