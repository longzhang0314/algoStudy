package cn.zl.algo.week03.exercise;

import java.util.Stack;

/**
 * @author: longzhang
 * @date: 2021/12/15
 */
public class Exercise08Test {

    public static void main(String[] args) {
        Exercise08Test e = new Exercise08Test();
        String s = "5+2*(3+1+4+2*3)+6/2";
        System.out.println(e.calc(s));
    }

    public int calc(String s) {
        if (s == null || s.length() == 0) return 0;
        int i = 0, n = s.length();
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        while (i < n) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
                continue;
            }
            if (isDigit(c)) {
                int digit = 0;
                while (i < n && isDigit(s.charAt(i))) {
                    digit = digit * 10 + (s.charAt(i) - '0');
                    i++;
                }
                nums.push(digit);
                continue;
            }
            if (c == '(') {
                ops.push(c);
                i++;
                continue;
            }

            if (c == ')') {
                while (ops.peek() != '(') {
                    fetchAndCalc(nums, ops);
                }
                ops.pop();
                i++;
                continue;
            }

            while (!ops.isEmpty() && !prior(c, ops.peek())) {
                fetchAndCalc(nums, ops);
            }
            ops.push(c);
            i++;
        }
        while (!ops.isEmpty()) {
            fetchAndCalc(nums, ops);
        }
        return nums.pop();
    }

    private boolean prior(char a, char b) {
        if (b == '(') return true;
        return (a == '*' || a== '/') && (b == '+' || b == '-');
    }

    private void fetchAndCalc(Stack<Integer> nums, Stack<Character> ops) {
        int k2 = nums.pop();
        int k1 = nums.pop();
        char op = ops.pop();
        int res = 0;
        switch (op) {
            case '+':
                res = k1 + k2;
                break;
            case '-':
                res = k1 - k2;
                break;
            case '*':
                res = k1 * k2;
                break;
            case '/':
                res = k1 / k2;
                break;
        }
        nums.push(res);
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
