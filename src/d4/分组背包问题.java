package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class 分组背包问题 {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static int N = 110;
    public static int[][] v = new int[N][N];
    public static int[][] w = new int[N][N];
    public static int[] s = new int[N];
    public static int[] f = new int[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();

        for (int i = 1; i <= n; i++) {
            s[i] = nextInt();
            for (int j = 1; j <= s[i]; j++) {
                v[i][j] = nextInt();
                w[i][j] = nextInt();
            }
        }

        for (int i = 1; i <= n; i++)
            for (int j = m; j > 0; j--)
                for (int k = 1; k <= s[i]; k++)
                    if (j >= v[i][k])
                        f[j] = Math.max(f[j], f[j - v[i][k]] + w[i][k]);

        System.out.println(f[m]);
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}
