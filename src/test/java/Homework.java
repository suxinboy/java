import org.junit.Test;

import java.io.*;
import java.util.Scanner;

public class Homework {

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("================");
            System.out.println();
            Scanner sc = new Scanner(System.in);
            long l = sc.nextLong();
//        byte[] bytes = LongtoBtye1(l);
            byte[] bytes = LongtoByte2(l);

//        BytetoLong(bytes);
//        String s = "12";
//        byte[] bytes1 = s.getBytes();
            BytetoLong(bytes);
        }
    }

    public static byte[] LongtoBtye1(long l) throws Exception {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);

        dos.writeLong(l);
        byte[] bytes = bos.toByteArray();
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }

        System.out.println(bytes.length);
        return bytes;
    }

    public static byte[] LongtoByte2(long l) {
        byte[] bytes = new byte[8];
        for (int i = 0; i < bytes.length; i++) {
            long l1 = (l >> 8 * (7 - i)) & 0xff;
            bytes[i] = (byte) l1;

        }
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }
        return bytes;
    }

    public static void BytetoLong(byte[] bytes) throws Exception {
        long s = 0;
        long s0 = bytes[0] & 0xff;
        long s1 = bytes[1] & 0xff;
        long s2 = bytes[2] & 0xff;
        long s3 = bytes[3] & 0xff;
        long s4 = bytes[4] & 0xff;
        long s5 = bytes[5] & 0xff;
        long s6 = bytes[6] & 0xff;
        long s7 = bytes[7] & 0xff;
        s6 <<= 8;
        s5 <<= 16;
        s4 <<= 24;
        s3 <<= 8 * 4;
        s2 <<= 8 * 5;
        s1 <<= 8 * 6;
        s0 <<= 8 * 7;
        s = s0 | s1 | s2 | s3 | s4 | s5 | s6 | s7;
        System.out.println(s);
    }

}
