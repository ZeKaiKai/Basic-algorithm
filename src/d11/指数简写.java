package d11;

import java.math.BigDecimal;
import java.math.BigInteger;

public class 指数简写 {
    public static void main(String[] args) {
        // 0.0001
        System.out.println(1e-4);
        System.out.println(1E-4);
        double t = 1e-4;
        System.out.println(t);

        System.out.println(BigDecimal.valueOf(1e-4));
        System.out.println(BigDecimal.valueOf(1e5));
    }
}
