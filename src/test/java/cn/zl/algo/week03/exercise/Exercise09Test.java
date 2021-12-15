package cn.zl.algo.week03.exercise;

import java.util.Stack;

/**
 * @author: longzhang
 * @date: 2021/12/15
 */
public class Exercise09Test {


    public String removeDuplicates(String s) {
        if (s == null || s.length() == 0) return s;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        char[] chs = new char[stack.size()];
        for (int i = chs.length - 1; i >= 0; i--) {
            chs[i] = stack.pop();
        }
        return new String(chs);
    }
}
