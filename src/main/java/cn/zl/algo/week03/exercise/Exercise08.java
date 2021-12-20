package cn.zl.algo.week03.exercise;

import java.util.Stack;

/**
 * 772. 基本计算器 III（困难 力扣会员，比上一题多了括号）
 *
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和左右两种括号()。 整数除法仅保留整数部分。
 *
 * @author: longzhang
 * @date: 2021/12/13
 */
public class Exercise08 {

    public static void main(String[] args) {
        Exercise08 e = new Exercise08();
        String s = "5+2*(3+1+4+2*3)+6/2";
        String s1 = "1+1";
        String s2 = "6-4/2";
        String s3 = "2*(5+5*2)/3+(6/2+8)"; // 21
        String s4 = "(2+6*3+5-(3*14/7+2)*5)+3"; // -12
        System.out.println(e.calculate(s));
        System.out.println(e.calculate(s1));
        System.out.println(e.calculate(s2));
        System.out.println(e.calculate(s3));
        System.out.println(e.calculate(s4));
    }

    // 5+2*(3+1+4+2*3)+6/2 = 16
    // 数字直接入栈； 符号先判断，
    //  ( 直接入栈，除括号
    //  ）栈顶符号位出栈进行计算，直到遇到左括号，左括号出栈
    //  其他符号，如果当前符号位不比栈顶优先，那么出栈进行计算
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        int i = 0, n = s.length();
        Stack<Character> ops = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        while (i < n) {
            char c = s.charAt(i);
            if (isDigit(c)) { // 数字
                int digit = 0;
                while (i < n && isDigit(s.charAt(i))) {
                    digit = digit * 10 + (s.charAt(i) - '0');
                    i++;
                }
                nums.push(digit);
                continue;
            } else if (!isOps(c)) {
                i++;
                continue;
            }
            // 符号处理
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
            } else {
                while (!ops.isEmpty() && !prior(c, ops.peek())) {
                    fetchAndCalc(nums, ops);
                }
                ops.push(c);
            }
            i++;
        }

        while (!ops.isEmpty()) {
            fetchAndCalc(nums, ops);
        }
        return nums.pop();
    }

    private void fetchAndCalc(Stack<Integer> nums, Stack<Character> ops) {
        int k2 = nums.pop();
        int k1 = nums.pop();
        int op = ops.pop();
        int res = 0;
        switch (op) {
            case '+':
                res =  k1 + k2;
                break;
            case '-':
                res =  k1 - k2;
                break;
            case '*':
                res =  k1 * k2;
                break;
            case '/':
                res =  k1 / k2;
                break;
            default:
        }
        nums.push(res);
    }

    private boolean prior(char a, char b) {
        if ((a == '*' || a == '/') && (b == '+' || b == '-')) return true;
        if (b == '(') return true;
        return false;
    }


    private boolean isOps(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')';
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
