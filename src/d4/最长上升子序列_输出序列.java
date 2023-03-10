package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * leetcode 300. 最长递增子序列
 */
public class 最长上升子序列_输出序列 {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int[] a = new int[n+1];
        int[] f = new int[n+1];
        // 记录从哪个状态转移过来的
        int[] g = new int[n+1];

        for (int i = 1; i <= n; i++)
            a[i] = nextInt();

        for (int i = 1; i <= n; i++) {
            f[i] = 1;
            g[i] = 1;
            for (int j = 1; j < i; j++)
                if (a[i] > a[j])
                    if (f[i] < f[j] + 1) {
                        f[i] = f[j] + 1;
                        g[i] = j;
                    }
        }

        int k = 0;
        for (int i = 1; i <= n; i++)
            if (f[i] > f[k])
                k = i;

        System.out.println(f[k]);

        // 反向输出最长序列
        int len = f[k];
        for (int i = 0; i < len; i++) {
            System.out.print(a[k] + " ");
            k = g[k];
        }
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}
// leetcode AC代码
//class Solution {
//    public int lengthOfLIS(int[] nums) {
//        int n = nums.length;
//        int[] a = new int[n+1];
//        int[] f = new int[n+1];
//
//        for (int i = 1; i <= n; i++)
//            a[i] = nums[i-1];
//
//        for (int i = 1; i <= n; i++) {
//            f[i] = 1;
//            for (int j = 1; j < i; j++) {
//                if (a[i] > a[j])
//                    f[i] = Math.max(f[i], f[j] + 1);
//            }
//        }
//
//        int max = 0;
//        for (int i = 1; i <= n; i++)
//            max = Math.max(f[i], max);
//
//        return max;
//    }
//}
