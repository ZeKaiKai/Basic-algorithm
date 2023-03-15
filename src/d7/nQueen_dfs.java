package d7;

import java.io.*;

public class nQueen_dfs {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static int N = 100;
    public static int n;
    public static char[][] path = new char[N][N];
    public static boolean[] col = new boolean[N]; // 标记列
    public static boolean[] dg = new boolean[N];  // 标记对角线
    public static boolean[] udg = new boolean[N]; // 标记反对角线

    public static void main(String[] args) throws IOException {
        n = nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                path[i][j] = '.';
            }
        }
        dfs(0);
        out.flush();
    }

    public static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    out.print(path[i][j]);
                }
                out.println();
            }
            out.println();
        }
        // 枚举该行的n个点
        for (int i = 0; i < n; i++) {
            // 满足条件，则搜索
            if (!col[i] && !dg[u+i] && !udg[n-u+i]) {
                col[i] = dg[u+i] = udg[n-u+i] = true;
                path[u][i] = 'o';  //标记路线
                dfs(u+1);
                col[i] = dg[u+i] = udg[n-u+i] = false;
                path[u][i] = '.';
            }
        }
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}
