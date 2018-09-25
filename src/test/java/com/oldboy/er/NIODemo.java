package com.oldboy.er;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIODemo {
    public static void main(String[] args) throws Exception {

        FileInputStream fin = new FileInputStream("E:\\abc\\8.txt");

        //得到文件通道
        FileChannel fcin = fin.getChannel();
        //输出部分
        FileOutputStream fout = new FileOutputStream("E:\\abc\\1.txt");
        FileChannel fcout = fout.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(1024);
        while(fcin.read(buf)!= -1){
            buf.flip();
            fcout.write(buf);
            buf.flip();
        }
        fcin.close();
        fout.close();
        fin.close();
        fcout.close();
    }
}
