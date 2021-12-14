package cn.zl.algo.week03.exercise;

import java.util.Stack;

/**
 * 42. 接雨水（困难）单调栈
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * @author: longzhang
 * @date: 2021/12/14
 */
public class Exercise12 {

    // 方法1：暴力法。每根柱子去找左右两边最高柱子的较小值，然后可以计算出当前柱子位置可接的雨水
    public int trap(int[] height) {
        if (height == null || height.length <=2) return 0;
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

    // 方法2：方法1的基础上改良，将每个位置对应的左边最大值和右边最大值记录下来，方便查找
    public int trap2(int[] height) {
        if (height == null || height.length <=2) return 0;
        int n = height.length;
        int res = 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        for (int j = n - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], height[j + 1]);
        }
        for (int i = 1; i < n; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            if (min > height[i]) {
                res += min - height[i];
            }
        }
        return res;
    }

    // 方法3：单调栈
    public int trap3(int[] height) {
        if (height == null || height.length <=2) return 0;
        int n = height.length;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int pop = stack.pop();
                while (!stack.isEmpty() && height[stack.peek()] == height[pop]) {
                    stack.pop();
                }
                if (stack.isEmpty()) break;

                int width = i - stack.peek() - 1;
                int h = Math.min(height[stack.peek()], height[i]) - height[pop];
                res += width * h;
            }
            stack.push(i);
        }
        return res;
    }
}
