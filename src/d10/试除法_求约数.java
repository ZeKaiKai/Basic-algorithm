package d10;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 试除，从2枚举到根号n
 */
public class 试除法_求约数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n-- != 0) {
            int x = in.nextInt();
            LinkedList<Integer> res = get_divisors(x);
            for (Integer re : res) {
                System.out.print(re + " ");
            }
            System.out.println();
        }
    }

    public static LinkedList<Integer> get_divisors(int n) {
        LinkedList<Integer> res = new LinkedList<>();

        // n的约数最大到根号n
        for (int i = 1; i <= n / i; i++) {
            if (n % i == 0) {
                res.push(i);
                if (i != n / i) res.push(n / i);  //当i*i=n时，防止重复
            }
        }

        Collections.sort(res);
        return res;
    }
}

//用例
//2
//6
//8