package two.week03;

import java.util.Stack;

/**
 * @author liusha
 * @date 2022/6/29
 */
public class Exercise13Test2 {


    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length;
        int res = 0;
        // 两端增加哨兵
        int[] newArr = new int[n + 2];
        for (int i = 0; i < n; i++) {
            newArr[i + 1] = heights[i];
        }
        // 单调递增，当遇到小于栈顶时，栈顶出栈计算矩形面积
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n + 2; i++) {
            while (!stack.isEmpty() && newArr[i] < newArr[stack.peek()]) {
                int pop = stack.pop();
                while (!stack.isEmpty() && newArr[pop] == newArr[stack.peek()]) {
                    stack.pop();
                }
                // 弹出后不可能为空，因为哨兵两端0，必小于当前元素
                int h = newArr[pop];
                int w = i - stack.peek() - 1;

                res = Math.max(res, w * h);

            }
            stack.push(i);
        }
        return res;
    }
}
