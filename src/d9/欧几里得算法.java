package d9;

import java.util.Scanner;

public class 欧几里得算法 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        System.out.printf("%d\n", gcd(a, b));
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }
}
