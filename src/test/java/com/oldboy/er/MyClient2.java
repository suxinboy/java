package com.oldboy.er;

import java.io.OutputStream;
import java.net.Socket;

public class MyClient2 {
    /**
     * Created by Administrator on 2018/9/7.
     */
    public static class MyClient {
        public static void main(String[] args) throws Exception {
            Socket s = new Socket("192.168.13.16", 9999);
            OutputStream out = s.getOutputStream();
            int i = 0 ;
            while(true){
                out.write(("hello " + i + "\r\n").getBytes());
                out.flush();
                i ++ ;
                Thread.sleep(1000);
            }
        }
    }

}
