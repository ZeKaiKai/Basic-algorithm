package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class 多重完全背包2 {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();
        int[] v = new int[12000];
        int[] w = new int[12000];
        int[] f = new int[m + 1];

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            int a, b, s;
            a = nextInt();
            b = nextInt();
            s = nextInt();
            int k = 1;
            while (k <= s) {
                cnt ++;
                v[cnt] = k * a;
                w[cnt] = k * b;
                s -= k;
                k *= 2;
            }
            if (s > 0) {
                cnt ++;
                v[cnt] = s * a;
                w[cnt] = s * b;
            }
        }

        for (int i = 1; i <= n; i++)
            for (int j = m; j >= v[i]; j--)
                f[j] = Math.max(f[j], f[j-v[i]]+w[i]);

        System.out.println(f[m]);
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}
