package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 滚动数组优化
 */
public class DP完全背包_ {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();
        int[] v = new int[n + 1];
        int[] w = new int[n + 1];
        int[] f = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            v[i] = nextInt();
            w[i] = nextInt();
        }

        for (int i = 1; i <= n; i++)
            for (int j = v[i]; j <= m; j++)
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);

        System.out.println(f[m]);
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}


/**
 * f[i][j] = max(f[i-1][j], f[i-1][j-v[i]]+w[i], f[i-1][j-2*v[i]]+2*w[i], f[i-1][j-3*v[i]]+3*w[i])
 * f[i][j-v[i]] = max(      f[i-1][j-v[i]],      f[i-1][j-2*v[i]]+w[i],   f[i-1][j-2*v[i]]+2*w[i] + f[i-1][j-3*v[i]])
 */