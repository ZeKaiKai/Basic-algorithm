package d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;

/**
 * P1775 石子合并（弱化版）
 */
public class 合并石子_区间dp {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = nextInt();
        int[] a = new int[n+1];
        int[] s = new int[n+1];
        int[][] f = new int[n+1][n+1];

        int cur = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = nextInt();
            cur += a[i];
            s[i] = cur;
        }

        // 枚举区间长度，最大到n
        for (int len = 2; len <= n; len++) {
            // 枚举起点，终点r最大也是到n
            for (int i = 1; i + len - 1 <= n; i++) {
                int l = i, r = i + len - 1;
                f[l][r] = 100000000;
                // 枚举划分点，最大到r-1
                for (int k = l; k < r; k++) {
                    f[l][r] = Math.min(f[l][r], f[l][k] + f[k+1][r] + s[r] - s[l-1]);
                }
            }
        }

        System.out.println(f[1][n]);
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}

