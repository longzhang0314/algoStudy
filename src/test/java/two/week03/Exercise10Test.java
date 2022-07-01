package two.week03;

import java.util.Stack;

/**
 * @author liusha
 * @date 2022/6/29
 */
public class Exercise10Test {


    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        if (pushed == null || popped == null) return false;
        if (pushed.length != popped.length) return false;
        int j = 0;
        int n = pushed.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            // 先尝试push1个
            stack.push(pushed[i]);
            // 每push1个都尝试去pop
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
