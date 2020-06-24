package com.cqupt.pip;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Run {
    public static void main(String[] args) throws IOException, InterruptedException {
        WriteData writeData = new WriteData();
        ReadData readData = new ReadData();
        PipedInputStream in = new PipedInputStream();
        PipedOutputStream out = new PipedOutputStream();

        //使用connect的作用是 使两个Stream之间产生同行链接，这样才可以将数据进行输出输入。
        //in.connect(out)
        out.connect(in);

        ReadThread readThread = new ReadThread(readData, in);
        WriteThread writeThread = new WriteThread(writeData, out);

        readThread.start();

        Thread.sleep(2000);

        writeThread.start();
    }
}