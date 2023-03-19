package d10;

import java.util.Scanner;

public class 试除法_分解质因数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n-- != 0) {
            int x = in.nextInt();
            divide(x);
        }
    }

    public static void divide(int x) {
        for (int i = 2; i < x / i; i++) {
            if (x % i == 0) {
                int s = 0;
                while (x % i == 0) {
                    x /= i;
                    s++;
                }
                System.out.printf("%d %d\n", i, s);
            }
        }
        // x分解的质因数中，最多只有一个大于x/i(根号x)
        if (x > 1) {
            System.out.printf("%d %d\n", x ,1);
        }
    }
}

//用例
//2
//6
//8