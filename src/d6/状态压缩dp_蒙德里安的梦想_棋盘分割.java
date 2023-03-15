package d6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 基础课动态规划(三)，视频一个小时前
 * 还未理解：
 *          st[i]的意义？st[j|k]的意义？
 */
public class 状态压缩dp_蒙德里安的梦想_棋盘分割 {
    public static int N = 12;
    public static int M = 1 << N;
    public static long[][] f = new long[N][M];
    public static boolean st[] = new boolean[M];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = 0, m = 0;
        while ((n = in.nextInt()) != 0 && (m = in.nextInt()) != 0) {

            for (int i = 0; i < N; i++)
                Arrays.fill(f[i], 0);

            for (int i = 0; i < 1 << n; i++) {
                st[i] = true;
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    // 第j位是1
                    if ((i >> j & 1) == 1) {
                        // 前面存在奇数个0
                        if ((cnt & 1) == 1)  st[i] = false;
                        cnt = 0;
                    } else {
                        cnt ++;
                    }
                }
                if ((cnt & 1) == 1) st[i] = false;
            }

            f[0][0] = 1;
            for (int i = 1; i <= m; i++)
                for (int j = 0; j < 1 << n; j++)
                    for (int k = 0; k < 1 << n; k++)
                        // j是第i列的状态
                        // k是第i-1列的状态
                        // j&k == 0表示不存在冲突
                        // st[j|k]表示
                        if ((j & k) == 0 && st[j | k])
                            f[i][j] += f[i-1][k];

            System.out.println(f[m][0]);
        }
    }
}
