package d11;

import java.io.*;

/**
 * 以左边第一个数为基准x
 * 不断从右往左扫描比x小的数字，从左往右扫描比x大的数字，扫描到后两者交换，最后i和j相遇的时候，就可以保证
 */
public class 快速排序 {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static int N = 100010;
    public static int[] q = new int[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 0; i < n; i++)
            q[i] = nextInt();

        quick_sort(0, n - 1);

        for (int i = 0; i < n; i++)
            out.print(q[i] + " ");
        out.flush();
    }

    public static void quick_sort(int l, int r) {
        if (l >= r) return;
        int x = q[l], i = l-1, j = r+1;
        while (i < j) {
            do i++; while (q[i] < x);
            do j--; while (q[j] > x);
            if (i < j) {
                int t = q[i];
                q[i] = q[j];
                q[j] = t;
            }
        }
        quick_sort(l, j);
        quick_sort(j+1, r);
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}
