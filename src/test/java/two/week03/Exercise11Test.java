package two.week03;

import java.util.Stack;

/**
 * @author liusha
 * @date 2022/6/29
 */
public class Exercise11Test {

    //输入: temperatures = [73,74,75,71,69,72,76,73]
    //输出: [1,1,4,2,1,1,0,0]
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) return new int[0];
        int n = temperatures.length;
        int[] res = new int[n];
        // 单调递减，遇到大于栈顶的弹出
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int pop = stack.pop();
                res[pop] = i - pop;
            }
            stack.push(i);
        }

        return res;
    }
}
