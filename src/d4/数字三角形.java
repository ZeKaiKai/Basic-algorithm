package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 剑指 Offer II 100. 三角形中最小路径之和
 */
public class 数字三角形 {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static int[][] a = new int[210][210];
    public static int[][] f = new int[210][210];

    public static void main(String[] args) throws IOException {
        int n = nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                a[i][j] = nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j==1) f[i][j] = f[i-1][j] + a[i][j];
                else if (j == i) f[i][j] = f[i-1][j-1] + a[i][j];
                else f[i][j] = Math.min(f[i-1][j-1]+a[i][j], f[i-1][j]+a[i][j]);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++)
            min = Math.min(min, f[n][i]);

        System.out.println(min);
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}

// leetcode提交的代码
//class Solution {
//    public int minimumTotal(List<List<Integer>> triangle) {
//        int n = triangle.size();
//        int[][] f = new int[210][210];
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= i; j++) {
//                if(j==1) f[i][j] = f[i-1][j] + triangle.get(i-1).get(j-1);
//                else if (j == i) f[i][j] = f[i-1][j-1] + triangle.get(i-1).get(j-1);
//                else f[i][j] = Math.min(f[i-1][j-1]+triangle.get(i-1).get(j-1), f[i-1][j]+triangle.get(i-1).get(j-1));
//            }
//        }
//
//        int min = Integer.MAX_VALUE;
//        for (int i = 1; i <= n; i++)
//            min = Math.min(min, f[n][i]);
//
//        return min;
//    }
//}