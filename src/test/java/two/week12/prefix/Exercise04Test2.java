package two.week12.prefix;

import java.util.Stack;

/**
 * 42
 * @author 流沙
 * @date 2024/4/9
 */
public class Exercise04Test2 {

    public static void main(String[] args) {
        // height = [0,1,0,2,1,0,1,3,2,1,2,1]
        //输出：6
        Exercise04Test2 e = new Exercise04Test2();
        int[] trap = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] trap2 = {5,2,1,2,1,5};
        System.out.println(e.trap2(trap2)); // 14
    }

    // 1.prefix;2.stack
    public int trap2(int[] height) {
        // 单调递减栈
        // 1.当前柱子高度小于栈顶高度时，入栈
        // 2.当前柱子高度等于栈顶高度时，丢弃栈中更早的柱子，放入新的柱子（如果保留更早的柱子，会导致后面的面积多算）
        // 3.当前柱子高度大于栈顶柱子高度时，取出栈顶，以及取出后栈顶，计算该矩形可容纳水的面积
        if (height == null || height.length < 3) return 0;
        int n = height.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0 ; i < n; i++) {
            while (!stack.isEmpty()) {
                int peek = stack.peek();
                if (peek == -1) {
                    stack.push(i);
                    break;
                }
                int peekVal = height[peek];
                if (height[i] < peekVal) {
                    stack.push(i);
                    break;
                }
                if (height[i] == peekVal) {
                    stack.pop();
                    stack.push(i);
                    break;
                }
                int pop = stack.pop();
                int popVal = peekVal;
                if (stack.isEmpty() || stack.peek() == -1) {
                    stack.push(i);
                    break;
                }
                peek = stack.peek();
                peekVal = height[peek];
                int width = i - peek - 1;
                int h = Math.min(peekVal, height[i]) - popVal;
                res += (width * h);
            }
        }
        return res;
    }


    // 1:left max and right max
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        int n = height.length;
        // 包含当前节点的左侧左侧最大值
        int[] leftPrefix = new int[n];
        for (int i = 1; i < n; i++) {
            leftPrefix[i] = Math.max(leftPrefix[i - 1], height[i - 1]);
        }
        int[] rightPrefix = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            rightPrefix[i] = Math.max(rightPrefix[i + 1], height[i + 1]);
        }

        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            int min = Math.min(leftPrefix[i], rightPrefix[i]);
            if (height[i] < min) {
                res += (min - height[i]);
            }
        }
        return res;
    }

}
