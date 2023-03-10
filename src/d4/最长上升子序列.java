package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * leetcode 300. 最长递增子序列
 */
public class 最长上升子序列 {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int[] a = new int[n+1];
        int[] f = new int[n+1];

        for (int i = 1; i <= n; i++)
            a[i] = nextInt();


        for (int i = 1; i <= n; i++) {
            f[i] = 1;
            for (int j = 1; j < i; j++) {
                if (a[i] > a[j])
                    f[i] = Math.max(f[i], f[j] + 1);
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(f[i], max);
        }

        System.out.println(max);
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
