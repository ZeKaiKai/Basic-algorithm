package d8;

import java.util.Scanner;

public class 邻接表bfs_图中点的层次 {
    public static int n,m;
    public static int N = 100010;
    // 数组模拟队列
    public static int[] d = new int[N];
    public static int[] q = new int[N];
    // 数组存储邻接表
    public static int[] e = new int[N];
    public static int[] ne = new int[N];
    public static int[] h = new int[N];
    public static int idx = 1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 0; i < N; i++)
            h[i] = -1;

        for (int i = 0; i < m; i++) {
            int a = in.nextInt(), b = in.nextInt();
            add(a, b);
        }
        System.out.println(bfs());
    }

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static int bfs() {
        int hh = 0, tt = 0;
        q[0] = 1;
        for (int i = 0; i < N; i++)
            d[i] = -1;
        d[1] = 0;
        while (hh <= tt) {
            int t = q[hh];
            hh++;
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (d[j] == -1) {
                    d[j] = d[t] + 1;
                    // 入队列
                    tt++;
                    q[tt] = j;
                }
            }
        }
        return d[n];
    }
}

//测试样例
//        4 5
//        1 2
//        2 3
//        3 4
//        1 3
//        1 4