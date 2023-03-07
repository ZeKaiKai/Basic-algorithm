package d1;
import java.io.*;
import java.util.*;

// 待实现
public class 离散化_前缀和_区间和 {
    static int N = 300010;
    static Object[] a = new Object[N];
    static int[][] f = new int[N][2], t = new int[N][2];
    static int[] s = new int[N];
    static int n, m;

    //获取x映射到的下标
    private static int found(int x) {
        int l = 0, r = a.length - 1;
        while(l < r) {
            int mid = l + r >> 1;
            if((int)a[mid] >= x) r = mid;
            else l = mid + 1;
        }
        return r + 1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> set = new HashSet<>();
        String[] str1 = read.readLine().split(" ");
        n = Integer.parseInt(str1[0]);
        m = Integer.parseInt(str1[1]);
        //储存添加下标和数
        for (int i = 1; i <= n; i++) {
            str1 = read.readLine().split(" ");
            int x, c;
            x = Integer.parseInt(str1[0]);
            c = Integer.parseInt(str1[1]);
            f[i][0] = x;
            f[i][1] = c;
            set.add(x);
        }
        //储存求和区间
        for (int i = 1; i <= m; i++) {
            str1 = read.readLine().split(" ");
            int l, r;
            l = Integer.parseInt(str1[0]);
            r = Integer.parseInt(str1[1]);
            t[i][0] = l;
            t[i][1] = r;
            set.add(l);
            set.add(r);
        }
        //去重加排序
        a = set.toArray();
        Arrays.sort(a);

        //给区间赋值
        for (int i = 1; i <= n; i++) {
            int x = found(f[i][0]);
            s[x] += f[i][1];
        }

        //获取前缀和
        for (int i = 1; i <= set.size(); i++) s[i] += s[i - 1];

        for (int i = 1; i <= m; i++) {
            int x = found(t[i][0]);
            int y = found(t[i][1]);
            System.out.println(s[y] - s[x - 1]);
        }

    }
}

