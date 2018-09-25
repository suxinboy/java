package com.oldboy.er;

public class Work3  {
    public static void main(String[] args) {
        int[][] a = {
                {1,2, 3},
                {1,1,2}
        };
        int[][] b = {
                {3, 2},
                {1, 4}
        };

        mulmatrix(a, b);

    }

    public static void mulmatrix(int[][] a, int[][] b) {
        int n = a.length;
        int[][] r = new int[n][n];
        int count = 0;
        //
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    r[i][j] = r[i][j] + (a[i][k] * b[k][j]);
                    count++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(r[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println(count);
    }

}
