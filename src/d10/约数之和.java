package d10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 算术基本定理衍生结论，约数个数N = (a1+1)*...*(ak+1)
 * 其中a1...ak是分解出来的质数的指数
 *
 * 则约数之和sum = (p0^0 + ... + p0^ak) + ... + (pk^0 + ... + pk^ak)
 *
 * 解释：该式展开共N = (a1+1)*...*(ak+1)项，展开后的每一项都对应一个约数
 * 代码做法：先分解质因数，并存储对应质数和指数，根据while(a-- != 0)  t = (t * p + 1); 来计算
 *
 */
public class 约数之和 {
    public static int N = 100010;
    public static HashMap<Integer, Integer> primes = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        while (n-- != 0) {
            int x = in.nextInt();

            for (int i = 2; i <= x / i; i++) {
                while (x % i == 0) {
                    x /= i;
                    // 将map中的对应value加一
                    Integer t = 0;
                    if (primes.containsKey(i))  {
                        t = primes.get(i);
                        primes.remove(i);
                    } else {
                        t = 0;
                    }
                    primes.put(i, t + 1);
                }
            }

            // 将map中的对应value加一
            if (x > 1) {
                Integer t = 0;
                if (primes.containsKey(x))  {
                    t = primes.get(x);
                    primes.remove(x);
                } else {
                    t = 0;
                }
                primes.put(x, t + 1);
            }
        }

        long res = 1;
        for (Map.Entry<Integer, Integer> prime : primes.entrySet()) {
            int p = prime.getKey(), a = prime.getValue();
            long t = 1;
            /**
             * 未循环前：t = 1
             * 一次循环：t = p + 1
             * 两次循环：t = (p+1)*p + 1 = p^2 + p + 1
             * n次循环： t = p^n + p^(n-1) + ... + 1
             */
            while(a-- != 0)
                t = (t * p + 1);
            res = res * t;
        }

        System.out.println(res);
    }
}


