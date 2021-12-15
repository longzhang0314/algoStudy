package cn.zl.algo.week03.exercise;

import java.util.Stack;

/**
 * @author: longzhang
 * @date: 2021/12/15
 */
public class Exercise12Test {

    /**
     * 接雨水
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
       if (height == null || height.length == 0) return 0;
       int n = height.length;
       int res = 0;
       for (int i = 1; i < n - 1; i++) {
           int leftMax = 0, rightMax = 0;
           for (int j = 0; j < i; j++) {
               leftMax = Math.max(leftMax, height[j]);
           }
           for (int k = i + 1; k < n; k++) {
               rightMax = Math.max(rightMax, height[k]);
           }
           int min = Math.min(leftMax, rightMax);
           if (min > height[i]) {
               res += min - height[i];
           }
       }
       return res;
    }

    // 动态规划
    public int trap2(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n = height.length;
        int res = 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }

        for (int i = 1; i < n; i++) {
            int left = leftMax[i], right = rightMax[i];
            int min = Math.min(left, right);
            if (min > height[i]) {
                res += min - height[i];
            }
        }
        return res;
    }

    public int trap3(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n = height.length;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int pop = stack.pop();
                while (!stack.isEmpty() && height[pop] == height[stack.peek()]) {
                    pop = stack.pop();
                }
                if (!stack.isEmpty()) {
                    int peek = stack.peek();
                    int h = Math.min(height[peek], height[i]);
                    int width = i - peek - 1;
                    res += width * h;
                }
            }
            stack.push(i);
        }
        return res;
    }
}
