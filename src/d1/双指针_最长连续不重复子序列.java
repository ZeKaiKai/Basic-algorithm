package d1;

import java.util.HashSet;
import java.util.Scanner;

/************剑指 Offer II 016. 不含重复字符的最长子字符串***********/
public class 双指针_最长连续不重复子序列 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        char[] c = s.toCharArray();
        HashSet<Character> set = new HashSet<>();

        int res = 0;
        // 双指针扫描
        for (int i = 0, j = 0; i < c.length; i++) {
            // 包含重复元素，重复的一定是新读入的
            // 剔除前面元素，直到无重复
            while(set.contains(c[i])) {
                set.remove(c[j]);
                j++;
            }
            set.add(c[i]);
            res = Math.max(res, set.size());
        }

        System.out.println(res);
    }
}
