package d9;

import java.util.Scanner;

public class 普通筛质数 {
    public static int N = 1000010;
    public static int[] primes = new int[N];
    public static boolean[] st = new boolean[N];
    public static int cnt = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        get_primes(n);
        System.out.println(cnt);
    }

    public static void get_primes(int n) {
        for (int i = 2; i < n; i++) {
            if (!st[i])
                primes[cnt++] = i;
            for (int j = i + i; j < n; j += i)
                st[j] = true;
        }
    }
}
