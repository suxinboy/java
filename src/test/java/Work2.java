import org.junit.Test;

public class Work2 {

    @Test
    public void test5Billion() {

        int len = Integer.MAX_VALUE / 8 + 1;
        byte[] bytes = new byte[len];

        int[] arr = new int[50000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * Integer.MAX_VALUE);
        }
        for (int b : arr) {
            int index = b / 8;
            int bit = b % 8;
            if (bytes[index] != -1) {
                bytes[index] = (byte) (bytes[index] | (1 << bit));
            }

        }

        System.out.println(count(bytes));
    }

    public static int count(byte[] bytes) {
        int n = 0;
        for (byte b : bytes) {
            for (int i = 0; i < 8; i++) {
                n = n + ((b >> i) & 0x1);
            }
        }
        return n;
    }

}
