package d9;

import java.util.*;

// 参考https://blog.csdn.net/qq_41810415/article/details/126251195
public class 离散化 {
    public static int N = 300010;
    public static int[] a = new int[N];
    public static int[] s = new int[N];
    public static List<Integer> alls = new ArrayList<>();
    public static ArrayList<Pair> adds = new ArrayList<>();  //加数操作
    public static ArrayList<Pair> query = new ArrayList<>(); //查询操作

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        // n次操作
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int c = in.nextInt();
            alls.add(x);
            adds.add(new Pair(x, c));
        }

        // m次询问
        for (int i = 0; i < m; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            query.add(new Pair(l, r));
            alls.add(l);
            alls.add(r);
        }

        // java离散化操作
        alls = new ArrayList<>(new HashSet<>(alls));
        Collections.sort(alls);

        for (Pair item : adds) {
            int index = find(item.first); // 在alls中找到对应坐标
            a[index] += item.second;
        }

        // 前缀和
        for (int i = 1; i <= alls.size(); i++)
            s[i] = s[i-1] + a[i];

        for (Pair item : query) {
            int l = find(item.first);
            int r = find(item.second);
            System.out.println(s[r] - s[l-1]);
        }
    }

    public static int find(int x) {
        int l = 0, r = alls.size() - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (alls.get(mid) <= x)
                l = mid;
            else
                r = mid - 1;
        }
        return l + 1;
    }

    static class Pair {
        int first;
        int second;
        public Pair(int x, int c) {
            this.first = x;
            this.second = c;
        }
    }
}

//测试用例
//        3 3
//        1 2
//        3 6
//        7 5
//        1 3
//        4 6
//        7 8


