package two.week03;

import java.util.Stack;

/**
 * @author liusha
 * @date 2022/6/29
 */
public class Exercise09Test {

    // 1047
    public String removeDuplicates(String s) {
        if (s == null) return s;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        char[] res = new char[stack.size()];
        for (int i = res.length - 1; i >= 0; i++) {
            res[i] = stack.pop();
        }
        return new String(res);
    }
}
