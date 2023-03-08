package d2;

import java.util.Scanner;

/**
 * acwing2 01背包问题
 *
 */
public class DP01背包 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] v = new int[n+1];
        int[] w = new int[n+1];
        int[] f = new int[m+1];

        for (int i = 1; i <= n; i++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }
        // f[0][0-m]考虑0件物品，价值都为0
//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j <= m; j++) {
//                // 不包含第i件物品
//                f[i][j] = f[i-1][j];
//                // 当前容量大于第i件物品时才考虑加入i物品
//                if (j >= v[i])
//                    f[i][j] = Math.max(f[i][j], f[i-1][j-v[i]]+w[i]);
//            }
//        }

        // 滚动数组优化为一维
        for (int i = 1; i <= n; i++)
            for (int j = m; j >= v[i]; j--)
                // 当前容量大于第i件物品时才考虑加入i物品
                f[j] = Math.max(f[j], f[j-v[i]]+w[i]);


        System.out.println(f[m]);
    }
}
