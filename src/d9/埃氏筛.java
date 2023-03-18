package d9;

import java.util.Scanner;

public class 埃氏筛 {
    public static int cnt = 0;
    public static int[] primes = new int[1000010];
    public static boolean[] st = new boolean[1000010];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        prime(n);
        System.out.println(cnt);
    }

    public static void prime(int n) {
        // 时间复杂度是nlog(logn)
        for (int i = 2; i <= n; i ++) {
            if (!st[i]) {
                primes[cnt++] = i;
                for (int j = i + i; j <= n; j+=i) {
                    st[j] = true;
                }
            }
        }
    }
}

//用例
//2
//6
//8