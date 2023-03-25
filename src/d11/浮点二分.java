package d11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 洛谷P1024 [NOIP2001 提高组] 一元三次方程求解
 */
public class 浮点二分 {
    public static double a;
    public static double b;
    public static double c;
    public static double d;
    public static ArrayList<Double> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        a = in.nextDouble();
        b = in.nextDouble();
        c = in.nextDouble();
        d = in.nextDouble();

        for (double i = -100; i <= 100; i++) {
            double l = i, r = i + 1;
            if (func(l) == 0) {
                res.add(l);
            }
            // 如果可能存在解，二分查找i到i+1之间的答案
            if (func(l) * func(r) < 0) {
                while (r - l > 0.0001) {
                    double mid = (l + r) / 2;
                    if (func(l) * func(mid) <= 0) r = mid;
                    else l = mid;
                }
                res.add(l);
            }
        }

        for (Double re : res)
            System.out.printf("%.2f ", re);
    }

    public static double func(double x) {
        return a * x * x * x + b * x * x + c * x + d;
    }
}
