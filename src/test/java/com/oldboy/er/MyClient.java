package com.oldboy.er;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("127.0.0.1", 9999);
        OutputStream out = s.getOutputStream();
        Scanner sc = new Scanner(System.in);
        while (true){

            System.out.println("发送：");
            String s1 = sc.next();
            String s2 = s1 + "\r\n";
            out.write(s2.getBytes());
            out.flush();
            Thread.sleep(10);

        }
        
    }
}
