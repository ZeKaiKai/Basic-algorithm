package d12;

import java.util.Arrays;
import java.util.Stack;

/**
 * Leetcode 503. 下一个更大元素 II
 * 单调栈例题
 */
public class 单调栈 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};

        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.empty() && nums[i%n]>nums[stack.peek()]) {
                res[stack.peek()] = nums[i%n];
                stack.pop();
            }
            stack.push(i%n);
        }
    }
}
