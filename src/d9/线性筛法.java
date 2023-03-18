package d9;

import java.util.Scanner;

public class 线性筛法 {
    public static int N = 10000010;
    public static int cnt = 0;
    public static int[] primes = new int[N];
    public static boolean[] st = new boolean[N];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        get_primes(n);
        System.out.println(cnt);
    }

    public static void get_primes(int n) {
        for (int i = 2; i < n; i ++) {
            if (!st[i]) primes[cnt++] = i;
            for (int j = 0; primes[j] <= n / i; j ++) {
                // 只用最小质因子来筛掉后续的一个合数，也就是对于每个数只筛一次，所以称为线性筛
                /*
                    当i%pj!=0时，因为pj是从小到大枚举的，所以pj一定小于i的最小质因子，所以可以筛掉st[pj*i]
                    当i%pj==0时，因为pj是从小到大枚举的，所以pj一定等于i的最小质因子，所以可以筛掉st[pj*i]
                 */
                /*
                    正确性证明：对于任意合数x，假设pj是x的最小质因子，
                    i一定会枚举到x/pj，也就是st[pj*i]必然执行，也就是x必然会被筛掉
                 */
                st[primes[j] * i] = true;
                if (i % primes[j] == 0) break;
            }
        }
    }
}
