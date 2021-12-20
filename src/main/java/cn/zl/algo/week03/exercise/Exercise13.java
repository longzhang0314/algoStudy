package cn.zl.algo.week03.exercise;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形（困难）单调栈
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 *
 * @author: longzhang
 * @date: 2021/12/14
 */
public class Exercise13 {

    // 方法1：暴力法，找左右两次第一个小于当前柱子的值，得到以当前柱子高度形成的矩形
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

    // 方法2：暴力法改进，当前位置左右两次第一个小于当前值的位置提前存储起来
    //【注意】错误解法，因为不好找到状态转移方程，每个位置的左边第一个小于当前位置的数，其实不好从i-1转移过来
    public int largestRectangleArea2(int[] heights) {
        if (heights == null) return 0;
        int n = heights.length;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        for (int i = 0; i < n; i++) {
            leftMin[i] = -1;
            rightMin[i] = n;
        }
        for (int i = 1; i < n; i++) {
            // 看似合理，其实细想是错的转移方程
            leftMin[i] = heights[i - 1] < heights[i] ? i - 1 : leftMin[i - 1];
        }
        for (int j = n - 2; j >= 0; j--) {
            rightMin[j] = heights[j + 1] < heights[j] ? j + 1 : rightMin[j + 1];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, heights[i] * (rightMin[i] - leftMin[i] - 1));
        }
        return res;
    }

    // 方法3：单调栈。单调递增栈，找到第一个小于栈顶元素的值
    public int largestRectangleArea3(int[] heights) {
        if (heights == null) return 0;
        int n = heights.length;
        // 哨兵，左右各加一个高度为0的值，不用做特殊处理
        int[] newArr = new int[n + 2];
        for (int i = 0; i < n; i++) {
            newArr[i + 1] = heights[i];
        }
        int res = 0;
        // 单调递增栈，下一个元素小于栈顶元素就出栈
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < n + 2; i++) {
            while (!stack.isEmpty() && newArr[i] < newArr[stack.peek()]) {
                int pop = stack.pop();
                while (!stack.isEmpty() && newArr[stack.peek()] == newArr[pop]) {
                    stack.pop();
                }
                int h = newArr[pop];
                int width = i - stack.peek() - 1;
                res = Math.max(res, h * width);
            }
            stack.push(i);
        }
        return res;
    }
}
