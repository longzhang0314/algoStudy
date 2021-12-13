package cn.zl.algo.week03.example;

import java.util.Stack;

/**
 * 计算器/表达式求值
 *
 * 给定一个包含正整数、加（+）、减（-）、乘（*）、除（/）的算术表达式，计算其结果。
 *
 * 表达式仅包含非负整数、+、-、*、/、四种运算符和空格，整数除法仅保留整数部分。
 *
 * @author liusha
 * @date 2021/12/13
 */
public class Example03 {

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
            if (!isOps(c)) {
                num.push(c - '0');
                i++;
                continue;
            }
            while (!ops.isEmpty() && !prior(c, ops.peek())) {
                // 可计算
                int k2 = num.pop();
                int k1 = num.pop();
                int res = calc(k1, k2, ops.pop());
                num.push(res);
            }
            ops.push(c);
            i++;
        }
        if (!ops.isEmpty()) {
            int k2 = num.pop();
            int k1 = num.pop();
            int res = calc(k1, k2, ops.pop());
            num.push(res);
        }
        return num.pop();
    }

    private int calc(int k1, int k2, char ops) {
        switch (ops) {
            case '+':
                return k1 + k2;
            case '-':
                return k1 - k2;
            case '*':
                return k1 * k2;
            case '/':
                return k1 / k2;
        }
        return 0;
    }

    private boolean prior(char ops1, char ops2) {
        if (ops1 == '+' || ops1 == '-') return false;
        if (ops2 == '*' || ops2 == '/') return false;
        return true;
    }

    private boolean isOps(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
