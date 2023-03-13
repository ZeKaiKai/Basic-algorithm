package d6;

import java.util.Scanner;

public class 整数划分_ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] f = new int[n + 1][n + 1];

        // 第二种划分方式
        // 最小值为1的方案（方案中必定有1）
        //      考虑删掉1的方案，f[i-1][j-1]
        // 最小值大于1的方案（方案中必定没1，且都大于1）
        //      考虑j个数全部-1的方案，f[i-j][j]
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                f[i][j] = f[i - 1][j - 1] + f[i - j][j];
            }
        }

        int res = 0;
        for (int i = 1; i <= n; i++)
            res += f[n][i];

        System.out.println(res);
    }
}
