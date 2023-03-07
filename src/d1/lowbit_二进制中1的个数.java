package d1;

import java.util.Scanner;

//剑指 Offer 15. 二进制中1的个数
public class lowbit_二进制中1的个数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String bin = in.next();
        int n = Integer.parseInt(bin, 2);
        int cnt = 0;
        while (n != 0) {
            n -= n & (-n);
            cnt++;
        }
        System.out.println(cnt);
    }
}
