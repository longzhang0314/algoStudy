package cn.zl.algo.week03.exercise;

import java.util.Stack;

/**
 * @author: longzhang
 * @date: 2021/12/15
 */
public class Exercise10Test {

    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        if (pushed == null || pushed.length == 0) return true;
        Stack<Integer> stack = new Stack<>();
        int i = 0, n = popped.length;
        for (int p : pushed) {
            stack.push(p);
            while (i < n && popped[i] == stack.peek()) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
