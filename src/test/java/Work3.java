import org.junit.Test;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Work3 {
    @Test
    public void outFile() throws Exception {

        FileOutputStream fos = new FileOutputStream("E:\\abc\\8.txt");


        byte[] a = "a".getBytes("unicode");
        byte[] bc = "bc".getBytes("unicode");


        fos.write(a);
        fos.write(bc);

        fos.close();
    }


    @Test
    public void testBatchInsert() {
        List<Integer> list = new ArrayList<Integer>();
        int n = 100000;
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list.add(0, i);
        }
        System.out.println(System.currentTimeMillis() - start);

        LinkedList<Integer> list1 = new LinkedList<Integer>();
        int n1 = 100000;
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < n1; i++) {
            list1.add(0, i);
        }
        System.out.println(System.currentTimeMillis() - start1);
    }


}
