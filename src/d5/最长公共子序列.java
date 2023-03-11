package d5;

import java.util.Scanner;

/**
 * 剑指 Offer II 095. 最长公共子序列
 * 集合划分四种情况，其中一种情况被包含于其它情况，实际上只有三种情况
 */
public class 最长公共子序列 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text1 = in.next();
        String text2 = in.next();

        int l1 = text1.length();
        int l2 = text2.length();

        int[][] f = new int[l1+1][l2+1];

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                f[i][j] = Math.max(f[i-1][j], f[i][j-1]);
                if (text1.charAt(i-1) == text2.charAt(j-1))
                    f[i][j] = Math.max(f[i][j], f[i-1][j-1]+1);
            }
        }

        System.out.println(f[l1][l2]);
    }
}
