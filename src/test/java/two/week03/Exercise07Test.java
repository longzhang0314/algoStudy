package two.week03;

import java.util.Stack;

/**
 *
 * * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 *  * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格。 整数除法仅保留整数部分。
 * @author liusha
 * @date 2022/6/7
 */
public class Exercise07Test {

    // 3+2*2 = 7
    public int calculate(String s) {
        if (s == null || s.length() == 0) return -1;
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
                continue;
            }
            if (isOp(c)) {
                while (!ops.isEmpty()) {
                    char peek = ops.peek();
                    if (isPrior(c, peek)) {
                        break;
                    }
                    int num2 = nums.pop();
                    int num1 = nums.pop();
                    char op = ops.pop();
                    int res = calc(num1, num2, op);
                    nums.push(res);

                }
                ops.push(c);
            } else {
                // 数字直接存
                int digit = c - '0';
                while (i + 1 < s.length()) {
                    if (isOp(s.charAt(i + 1))) {
                        break;
                    }
                    i++;
                    digit = digit * 10 + (s.charAt(i) - '0');
                }
                nums.push(digit);
            }
            i++;
        }

        while (!ops.isEmpty()) {
            int num2 = nums.pop();
            int num1 = nums.pop();
            char op = ops.pop();
            int res = calc(num1, num2, op);
            nums.push(res);
        }

        return nums.pop();

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

    private boolean isOp(char c) {
        boolean isDigit = c >= '0' && c <= '9';
        return !isDigit;
    }

    // a是否优先于b
    // 例如: a是x，b是+
    private boolean isPrior(char c1, char c2) {
        return (c1 == '*' || c1 == '/') && (c2 == '+' || c2 == '-');
    }
}
