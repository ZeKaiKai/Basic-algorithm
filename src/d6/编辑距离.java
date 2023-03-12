package d6;

import java.util.Scanner;

/**
 * leetcode 72. 编辑距离
 */
public class 编辑距离 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word1 = in.next();
        String word2 = in.next();

        int l1 = word1.length();
        int l2 = word2.length();

        int[][] f = new int[l1 + 1][l2 + 1];

        for (int i = 0; i <= l2; i++)
            f[0][i] = i;
        for (int i = 0; i <= l1; i++)
            f[i][0] = i;

        // 划分为四种情况
        // 插入对应f[i-1][j] + 1
        // 删除对应f[i][j-1] + 1
        // 修改对应f[i-1][j-1] + 1 (a[i]!=a[j])
        // 不作为对应f[i-1][j-1]  (a[i] == a[j])

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                f[i][j] = Math.min(f[i - 1][j] + 1, f[i][j - 1] + 1);
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    f[i][j] = Math.min(f[i][j], f[i-1][j-1]);
                else
                    f[i][j] = Math.min(f[i][j], f[i-1][j-1] + 1);
            }
        }

        System.out.println(f[l1][l2]);
    }
}
