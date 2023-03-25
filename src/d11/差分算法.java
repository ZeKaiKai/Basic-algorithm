package d11;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * Acwing 1952. 金发姑娘和 N 头牛
 * 差分例题
 * 差分的目的是为了方便区间修改操作，只需要修改差分数组c[l]和c[r+1]的值，就能达到修改原数组a[l]-a[r]值的效果，具体是c[l]+=x, c[r+1]-=x（为了不影响a[r]后面的值）
 * 而前缀和的目的是方便区间查询操作
 * 两者可以理解为逆操作
 */
public class 差分算法 {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static TreeMap<Integer, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        int N = nextInt();
        int X = nextInt();
        int Y = nextInt();
        int Z = nextInt();

        for (int i = 0; i < N; i++) {
            int l = nextInt();
            int r = nextInt();

            Map_update_add(l, Y-X);
            Map_update_add(r+1, Z-Y);
            Map_update_add(-1, X);
        }

        int ans = 0, cur = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            cur += entry.getValue();
            ans = Math.max(ans, cur);
        }
        System.out.println(ans);
    }

    public static void Map_update_add(int key, int value) {
        if (map.containsKey(key)) {
            int t = map.get(key);
            map.remove(key);
            map.put(key, t+value); // +=Y-X,记录该温度的变化量
        } else {
            map.put(key, value);
        }
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}