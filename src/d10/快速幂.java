package d10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * https://www.luogu.com.cn/problem/solution/P1226
 * 计算 a^n
 * 按照a的二进制，该位是1时，则需加上此时的a^(2^i)，否则不加
 * 每次循环，转向a二进制的下一位，且a=a*a
 *
 * 例子：求a^11，11的二进制是1011，则每位对应幂乘结果=a^4 + a^3*0 + a^2 + a^1
 */
public class 快速幂 {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        long a = nextInt();
        int k = nextInt();
        int p = nextInt();
        System.out.printf("%d^%d mod %d=%d", a, k, p, qmi(a, k, p));
    }

    public static long qmi(long a, int k, int p) {
        long res = 1;
        while (k != 0) {
            if ((k & 1) == 1) res = res * a % p;
            k >>= 1;
            a = a * a % p;
        }
        return res;
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}
