package d8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class 邻接表bfs_有向图的拓扑序列 {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static int N = 100010;
    public static int n, m;
    public static int[] h = new int[N];
    public static int[] e = new int[N];
    public static int[] ne = new int[N];
    public static int idx  = 1;
    public static int[] q = new int[N];
    public static int[] d = new int[N]; //记录每个点入度

    public static void main(String[] args) throws IOException {
        n = nextInt();
        m = nextInt();
        for (int i = 0; i < N; i++)
            h[i] = -1;

        for (int i = 0; i < m; i++) {
            int a = nextInt(), b = nextInt();
            add(a, b);
        }

        if (topSort()) {
            for (int i = 0; i < n; i++)
                System.out.print(q[i] + " ");
            System.out.println();
        } else {
            System.out.println("-1");
        }
    }

    public static boolean topSort() {
        int hh = 0, tt = -1;
        // 所有入度为0的点入队，因为它们都可以作为起点
        for (int i = 1; i <= n; i++)
            if (d[i] == 0)
                q[++tt] = i;
        //
        while (hh <= tt) {
            int t = q[hh++];
            // 枚举每个出度
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                d[j] --;
                if (d[j] == 0) q[++tt] = j;
            }
        }

        return tt == n-1;
    }

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}

//测试用例
//
//        3 3
//        1 2
//        2 3
//        1 3