package cn.zl.algo.week12.prefix.exercise;

import java.util.Stack;

/**
 * 42. 接雨水
 * <p>
 *
 * @author liusha
 * @date 2022/3/29
 */
public class Exercise04 {


    public int trap(int[] height) {
        if (height == null || height.length <= 2) return 0;
        int n = height.length;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int pop = stack.pop();
                if (stack.isEmpty()) break;
                while (!stack.isEmpty() && height[pop] == height[stack.peek()]) {
                    pop = stack.pop();
                }
                if (stack.isEmpty()) break;
                int width = i - stack.peek() - 1;
                int high = Math.min(height[i], height[stack.peek()]) - height[pop];
                res += width * high;
            }
            stack.push(i);
        }
        return res;
    }


    public int trap2(int[] height) {
        if (height == null || height.length <= 2) return 0;
        int n = height.length;
        int[] leftMax = new int[n];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        int[] rightMax = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }

        int sum = 0;
        for (int i = 1; i < n - 1; i++) {
            int high = Math.min(leftMax[i], rightMax[i]);
            sum += Math.max(0, high - height[i]);
        }
        return sum;
    }

}
