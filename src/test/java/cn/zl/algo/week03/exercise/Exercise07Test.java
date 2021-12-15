package cn.zl.algo.week03.exercise;


import java.util.Stack;

/**
 *
 * 面试题 16.26. 计算器
 *
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格。 整数除法仅保留整数部分。
 * @author liusha
 * @date 2021/12/15
 */
public class Exercise07Test {

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
                    digit = digit * 10 + digit;
                    i++;
                }
                nums.push(digit);
                continue;
            }

            // 符号处理
            while (!ops.isEmpty() && !prior(c, ops.peek())) {
                fetchAndCalc(nums, ops);
            }
            ops.push(c);

        }

        while (!ops.isEmpty()) {
            fetchAndCalc(nums, ops);
        }
        return nums.pop();
    }

    private boolean prior(char a, char b) {
        return (a == '*' || a == '/') && (b == '+' || b == '-');
    }

    private void fetchAndCalc(Stack<Integer> nums, Stack<Character> ops) {
        int k2 = nums.pop();
        int k1 = nums.pop();
        int op = ops.pop();
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
