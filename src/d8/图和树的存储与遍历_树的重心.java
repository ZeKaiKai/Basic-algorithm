package d8;

import java.io.*;

public class 图和树的存储与遍历_树的重心 {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static int N = 100010, M = N * 2;
    public static int n;
    public static int[] h = new int[N];
    public static int[] e = new int[M];
    public static int[] ne = new int[M];
    public static int idx = 0;
    public static boolean[] s = new boolean[N];
    public static int ans = N;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < N; i++)
            h[i] = -1;

        n = nextInt();
        for (int i = 0; i < n - 1; i++) {
            int a, b;
            a = nextInt();
            b = nextInt();
            add(a, b);
            add(b, a);
        }

        dfs(1);

        System.out.println(ans);
    }

    public static void add(int a, int b) {
        // https://www.acwing.com/blog/content/4663/
        // idx是边编号
        // e[idx]是该边终点
        // h[a]是该点，第一条边的编号
        // ne[idx]是第idx边的下一条边
        e[idx] = b;     //初始化该边终点为b
        ne[idx] = h[a]; //下一条边是a点此时的第一条边
        h[a] = idx;     //插入后，a点的第一条边变成了现在这条
        idx++;          //边编号+1
    }

    public static int dfs(int u) {
        s[u] = true;

        int sum = 1, res = 0;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!s[j]) {
                int s = dfs(j);
                res = Math.max(res, s);
                sum += s;
            }
        }
        res = Math.max(res, n - sum);

        ans = Math.min(ans, res);

        return sum;
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}
