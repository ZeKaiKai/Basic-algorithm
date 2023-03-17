package d8;

import java.util.Scanner;

public class 图和树的存储与遍历_树的重心 {
    public static int N = 100010;
    public static int M = 2 * N;
    public static int idx = 1;
    public static int[] h = new int[N];
    public static int[] ne = new int[M];
    public static int[] e = new int[M];
    public static boolean[] st = new boolean[N];
    public static int n;
    public static int ans = N;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 0; i < N; i++) {
            h[i] = -1;
        }
        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt(), b = in.nextInt();
            add(a, b);
            add(b, a);
        }

        dfs(1);

        System.out.println(ans);
    }

    public static int dfs(int u) {
        st[u] = true;
        int sum = 1;
        int res = 0;
        for(int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!st[j]) {
                int t = dfs(j);
                sum += t;
                res = Math.max(res, t);
            }
        }
        res = Math.max(res, n-res);
        ans = Math.min(res, ans);

        return sum;
    }

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
//测试样例
//9
//1 2
//1 7
//1 4
//2 8
//2 5
//4 3
//3 9
//4 6
