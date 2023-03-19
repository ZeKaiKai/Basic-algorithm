package d10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 算术基本定理衍生结论，约数个数N = (a1+1)*...*(ak+1)
 * 其中a1...ak是分解出来的质数的指数
 *
 * 所以先试除分解质数，并把质数和对应指数存入map中
 * 最后累积求解
 */
public class 约数个数 {
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
            res *= (prime.getValue() + 1);
        }

        System.out.println(res);
    }
}
