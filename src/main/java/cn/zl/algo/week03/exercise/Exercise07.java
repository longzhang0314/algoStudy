package cn.zl.algo.week03.exercise;

import java.util.Stack;

/**
 * 面试题 16.26. 计算器
 *
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格。 整数除法仅保留整数部分。
 *
 * @author: longzhang
 * @date: 2021/12/13
 */
public class Exercise07 {

    public static void main(String[] args) {
        String s = "3+2*2";
        Exercise07 e = new Exercise07();
        System.out.println(e.calculate(s));
    }

    // 3+2*2 = 7
    public int calculate(String s) {
        if (s == null) return 0;
        Stack<Integer> num = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int i = 0, n = s.length();
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
                num.push(digit);
                continue;
            }
            while (!ops.isEmpty() && !prior(c, ops.peek())) {
                int k2 = num.pop();
                int k1 = num.pop();
                char op = ops.pop();
                int res = calc(k1, k2, op);
                num.push(res);
            }
            ops.push(c);
            i++;
        }

        while (!ops.isEmpty()) {
            int k2 = num.pop();
            int k1 = num.pop();
            char op = ops.pop();
            int res = calc(k1, k2, op);
            num.push(res);
        }
        return num.pop();
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private int calc(int k1, int k2, char op) {
        switch(op) {
            case '+':
                return k1 + k2;
            case '-':
                return k1 - k2;
            case '*':
                return k1 * k2;
            case '/':
                return k1 / k2;
        }
        return -1;
    }

    private boolean prior(char c1, char c2) {
        return (c1 == '*' || c1 == '/') && (c2 == '+' || c2 == '-');
    }

    private boolean isOps(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
