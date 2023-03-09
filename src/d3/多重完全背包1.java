package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class 多重完全背包1 {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();
        int[] v = new int[n + 1];
        int[] w = new int[n + 1];
        int[] s = new int[n + 1];
        int[][] f = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            v[i] = nextInt();
            w[i] = nextInt();
            s[i] = nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k * v[i] <= j && k <= s[i]; k++) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - k * v[i]] + k * w[i]);
                }
            }
        }

        System.out.println(f[n][m]);
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}
