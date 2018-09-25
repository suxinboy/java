package com;

import org.junit.Test;
import sun.misc.Cleaner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestJVM {
    @Test
    public void testStack(){
        callSelf(1);
    }
    private void callSelf(int n){
        System.out.println(n);
        n++;
        callSelf(n);
    }

    public static void main(String[] args) throws InterruptedException {
       int n = 1024*1024*6;
        long start = System.nanoTime();
        for (int i =1;i<=10000;i++){
           byte[] bytes = new byte[n];
       }
        System.out.println(System.nanoTime() - start);
    }
    //堆外最大内存(2g)
    @Test
    public void testBits() throws Exception {
//        System.out.println("maxMemoryValue:"+sun.misc.VM.maxDirectMemory());
        ByteBuffer buffer=ByteBuffer.allocateDirect(0);
        Class c = Class.forName("java.nio.Bits");
        Field maxMemory = c.getDeclaredField("maxMemory");
        maxMemory.setAccessible(true);
        synchronized (c) {
            Long maxMemoryValue = (Long)maxMemory.get(null);
            System.out.println("maxMemoryValue:"+maxMemoryValue);
        }
    }

    //通过 ByteBuffer.allocateDirect()分配离堆内存,对其gc ?
    @Test
    public void testBitsGC() throws Exception {
        ByteBuffer buffer=ByteBuffer.allocateDirect(1024*1024*2);
        Field cleanerField = buffer.getClass().getDeclaredField("cleaner");
        cleanerField.setAccessible(true);
        Cleaner cleaner = (Cleaner) cleanerField.get(buffer);
        long start = System.nanoTime();
        cleaner.clean();
        System.out.println(System.nanoTime() - start);
    }
    //使用两种ByteBuffer实现2g以内的文件复制，测时间? (1k - 8m)
//    @Test
//    public void testCopy(){
//        ByteBuffer buf = ByteBuffer.allocateDirect(1024 * 1024 * 10);
//        buf.getc
//    }

    /**
     * 使用零拷贝技术实现复制，不超过2g
     */
    @Test
    public void testZeroCopy() throws Exception {
        File f = new File("E:\\LenovoQMDownloadSoftMgr\\hadoop-2.7.3.tar.gz");
        FileInputStream fis = new FileInputStream(f);
        FileChannel fcSrc = fis.getChannel();
        FileOutputStream fos = new FileOutputStream(new File("D:\\codec\\hadoop"));
        FileChannel fcDest = fos.getChannel();
        long start = System.currentTimeMillis();
        fcSrc.transferTo(0,f.length(),fcDest);
        fcSrc.close();
        fcDest.close();
        System.out.println(System.currentTimeMillis() - start);
    }
}
