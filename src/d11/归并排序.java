package d11;

import java.io.*;

/**
 * 快速排序中，如果碰到有序的序列，则需要开n个递归栈，容易stackoverflow
 * 而归并排序稳定开logn个栈，则一般不会溢出，所以Arrays.sort也是用归并排序实现的
 */
public class 归并排序 {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static int N = 1000010;
    public static int[] q = new int[N];
    public static int[] tmp = new int[N];
    public static int n;

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 0; i < n; i++)
            q[i] = nextInt();

        mergeSort(0, n - 1);

        for (int i = 0; i < n; i++)
            out.print(q[i] + " ");
        out.flush();
    }

    public static void mergeSort(int l, int r) {
        if (l >= r) return;

        int mid = l + r >> 1;
        mergeSort(l, mid);
        mergeSort(mid+1, r);

        int k=0, i=l, j=mid+1;
        while (i <= mid && j <= r)
            if (q[i] <= q[j]) tmp[k++] = q[i++];
            else tmp[k++] = q[j++];
        while (i <= mid) tmp[k++] = q[i++];
        while (j <= r) tmp[k++] = q[j++];

        for (i=l, j=0; j < k; i++,j++) q[i] = tmp[j];
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}
