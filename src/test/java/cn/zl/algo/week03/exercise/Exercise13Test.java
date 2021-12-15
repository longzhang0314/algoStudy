package cn.zl.algo.week03.exercise;

import java.util.Stack;

/**
 * @author: longzhang
 * @date: 2021/12/15
 */
public class Exercise13Test {

    // 柱状图中最大的矩形
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 找到i左右两侧第一个小于i的索引
            int left = -1, right = n;
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] < heights[i]) {
                    left = j;
                    break;
                }
            }
            for (int k = i + 1; k < n; k++) {
                if (heights[k] < heights[i]) {
                    right = k;
                    break;
                }
            }
            res = Math.max(res, heights[i] * (right - left - 1));
        }
        return res;
    }

    public int largestRectangleArea2(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length;
        int res = 0;
        // 左右两侧哨兵 = 0
        int[] arr = new int[n + 2];
        for (int i = 0; i < n; i++) {
            arr[i + 1] = heights[i];
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < n + 1; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                int pop = stack.pop();
                while (!stack.isEmpty() && arr[pop] == arr[stack.peek()]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int peek = stack.peek();
                    int h = arr[pop];
                    int width = i - peek - 1;
                    res = Math.max(res, width * h);
                }
            }
        }
        return res;
    }
}
