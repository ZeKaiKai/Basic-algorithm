package d7;

import java.io.*;

public class 排列数字_dfs {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static int N = 10;
    public static int n;
    public static int[] path = new int[N];
    public static boolean[] s = new boolean[N];


    public static void main(String[] args) throws IOException {
        n = nextInt();
        dfs(0);
        out.flush();
    }

    public static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                out.print(path[i]);
            }
            out.println();
        }
        // 枚举n个数字
        for (int i = 1; i <= n; i++) {
            if (!s[i]) {
                s[i] = true;
                path[u] = i;
                dfs(u+1);
                s[i] = false;
                path[u] = 0;
            }
        }
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}
