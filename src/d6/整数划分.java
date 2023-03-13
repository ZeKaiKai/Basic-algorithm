package d6;

import java.util.Scanner;

public class 整数划分 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
//        int[][] f = new int[n+1][n+1];
//
//        for (int i = 0; i <= n; i++) {
//            f[i][0] = 1;
//        }
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                // 枚举第i个数选几个
//                for (int k = 0; k * i <= j; k++) {
//                    f[i][j] += f[i-1][j-k*i];
//                }
//            }
//        }
//
//        System.out.println(f[n][n]);

        // 滚动数组优化为一维
        int[] f = new int[n+1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                f[j] = (f[j] + f[j-i]);
            }
        }

        System.out.println(f[n]);
    }
}
