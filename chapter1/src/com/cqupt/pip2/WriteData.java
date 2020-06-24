package com.cqupt.pip2;

import java.io.IOException;
import java.io.PipedWriter;

/**
 * className WriteData
 * description
 *
 * @author feng
 * @version 1.0
 * @date 2019/1/17 下午6:51
 */
public class WriteData {
    String str = "a";

    public void writeMethod(PipedWriter out) {
        synchronized (str) {
            try {
                System.out.println("write : ");
                for (int i = 0; i < 300; i++) {
                    String outData = "" + (i + 1);
                    out.write(outData);
                    System.out.print(outData + "**");
                }
                System.out.println();
                out.close();
                str.notify();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
