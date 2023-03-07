package d1;

public class 位运算输出第k位 {
    public static void main(String[] args) {

        int n = 10;
        for (int k = 3; k >= 0; k--) {
            System.out.print(n>>k&1);
        }
        // 1、n>>3&1  1&1
        // 2、n>>2&1  10&1
        // 3、n>>1&1  101&1
        // 4、n>>0&1  1010&1
    }

}
