package two.week03;

import java.util.Stack;

/**
 * @author liusha
 * @date 2022/6/29
 */
public class Exercise12Test2 {

    // 单调递减，当前高于栈顶就出栈
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int n = height.length;
        int res = 0;
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int pop = stack.pop();
                // 相等的全部取出
                while (!stack.isEmpty() && height[stack.peek()] == height[pop]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    break;
                }
                int peek = stack.peek();
                int h = Math.min(height[i], height[peek]) - height[pop];
                int w = i - peek - 1;
                res += w * h;

            }
            stack.push(i);
        }
        return res;
    }
}
