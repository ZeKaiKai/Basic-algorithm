package d10;

import java.util.Scanner;

/**
 * 容斥原理：为了计数时不重不漏，使重叠的部分不被重复计算，基本思想是：先不考虑重叠的部分，算出所有对象数目，然后再减去重复的数目，必要时还要加上多次减去的数目
 * <p>
 * 欧拉公式：从1-n中与n互质的数的个数N = N*(1-1/p1)*...*(1-1/pk)
 * 其中p1到pk是算术基本定理中的质数
 * <p>
 * 证明如下：
 * 类似于筛法，1-n中2的倍数共n/2个，1-n中3的倍数共n/3个...
 * 所以得出互质的数目共 n - n/2 - n/3 - ... - n/n？
 * 但是减去的倍数中存在重复部分，所以要加上重复减去的部分
 * 所以得出互质的数目共 n - (n/2 + n/3 - ... + n/n) + (n/(2*3) + n/(2*4) + ...)
 * 但是此时加上的数也存在重复部分，所以要减去重复加上的部分
 * 所以得出互质的数目共 n - (n/2 + n/3 - ... + n/n) + (n/(2*3) + n/(2*4) + ...) - (n/(2*3*4) + ...)
 * 以此类推，实际上偶数个数对应加上，奇数个数对应减去
 */
public class 欧拉函数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        while (n-- != 0) {
            int a = in.nextInt();
            int res = get_euler(a);
            System.out.println(res);
        }
    }
    public static int get_euler(int n) {
        int res = n;

        for (int i = 2; i < n / i; i++) {
            if (n % i == 0) {
                // 由res = res * (1 - 1/a)变形而来，防止出现小数
                res = res / i * (i - 1);
                while (n % i == 0) n /= i;
            }
        }

        if (n > 1) res = res / n * (n - 1);

        return res;
    }
}

//3
//3
//6
//8

//输出
//2
//2
//4