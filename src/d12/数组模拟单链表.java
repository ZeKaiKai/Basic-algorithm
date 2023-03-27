package d12;

import java.io.*;

public class 数组模拟单链表 {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static int N = 100010;
    public static int head;
    public static int[] e = new int[N];
    public static int[] ne = new int[N];
    public static int idx = 0;

    public static void main(String[] args) throws IOException {
        int m = nextInt();
        init();

        for (int i = 0; i < m; i++) {
            int k, x;
            String op = nextChar();

            if ("H".equals(op)) {
                x = nextInt();
                add_to_head(x);
            } else if ("D".equals(op)) {
                k = nextInt();
                if (k == 0) head = ne[head]; //删除第一个节点
                else remove(k-1);
            } else {
                k = nextInt();
                x = nextInt();
                add(k-1, x);
            }
        }

        for (int i = head; i != -1; i=ne[i]) {
            out.print(e[i] + " ");
        }
        out.flush();
    }

    public static void init() {
        head = -1;
        idx = 0;
    }

    public static void add_to_head(int x) {
        e[idx] = x; ne[idx] = head; head = idx++;
    }

    public static void remove(int k) {
        ne[k] = ne[ne[k]];
    }

    public static void add(int k, int x) {
        e[idx] = x; ne[idx] = ne[k]; ne[k] = idx++;
    }

    public static String nextChar() throws IOException {
        st.nextToken();
        return st.sval;
    }
    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}

//样例
//10
//H 9
//I 1 1
//D 1
//D 0
//H 6
//I 3 6
//I 4 5
//I 4 5
//I 3 4
//D 6

//输出6465