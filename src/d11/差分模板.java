package d11;

import java.io.*;

/**
 * P2367 语文成绩
 * 一维差分模板
 * re了最后一个点
 */
public class 差分模板 {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static int N = 1000010;
    public static int[] a = new int[N];
    public static int[] c = new int[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int p = nextInt();

        for (int i = 1; i <= n; i++){
            a[i] = nextInt();
            if (i==1) c[i] = a[i];
            else c[i] = a[i] - a[i-1];
        }

        for (int i = 0; i < p; i++) {
            int l = nextInt();
            int r = nextInt();
            int x = nextInt();
            c[l] += x;
            c[r+1] -= x;
        }

        int cur = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            cur += c[i];
            res = Math.min(res, cur);
        }

        System.out.println(res);
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}
