package d7;

import java.io.*;

public class nQueen_dfs_pri {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static int N = 100;
    public static int n;
    public static char[][] path = new char[N][N];
    public static boolean[] row = new boolean[N]; // 标记列
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
        dfs(0, 0, 0);
        out.flush();
    }

    public static void dfs(int x, int y, int s) {
        // 每一行越界后，跳到下一行
        if (y == n) {
            y = 0;
            x ++;
        }
        // 枚举完最后一行后
        if (x == n) {
            if (s == n) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        out.print(path[i][j]);
                    }
                    out.println();
                }
                out.println();
            }
            return;
        }

        // 不放皇后
        dfs(x, y+1, s);

        // 放皇后
        if (!row[x] && !col[y] && !dg[x+y] && !udg[n-x+y]) {
            path[x][y] = 'o';
            row[x] = col[y] = dg[x+y] = udg[n-x+y] = true;
            dfs(x, y+1, s+1);
            path[x][y] = '.';
            row[x] = col[y] = dg[x+y] = udg[n-x+y] = false;
        }
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}
