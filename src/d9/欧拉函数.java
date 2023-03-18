package d9;

import java.util.Scanner;

public class 欧拉函数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        while (n-- != 0) {
            int a = in.nextInt();
            int res = a;

            for (int i = 2; i < a / i; i++) {
                if (a % i == 0) {
                    res = res / i *(i-1);
                    while(a % i == 0) a /= i;
                }
            }

            if (a > 1) res = res / a * (a - 1);

            System.out.println(res);
        }
    }
}

//3
//3
//6
//8
