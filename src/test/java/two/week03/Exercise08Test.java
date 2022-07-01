package two.week03;

import java.util.Stack;

/**
 * @author liusha
 * @date 2022/6/29
 */
public class Exercise08Test {


    // + - * / ()
    public int calculate(String s) {
        if (s == null || s.length() == 0) return -1;
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int n = s.length();
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
                continue;
            }

            if (isDigit(c)) {
                int digit = c - '0';
                while (i + 1 < n) {
                    if (!isDigit(s.charAt(i + 1))) {
                        break;
                    }
                    i++;
                    digit = digit * 10 + (s.charAt(i) - '0');
                }
                nums.push(digit);
                i++;
                continue;
            }

            // 非数字
            // 原则：栈中不可能存储右括号
            // 左括号：直接入；
            // 右括号：出栈到栈顶第一个左括号出栈，生成一个数字到数字栈
            // 加减乘除：判断当前操作符是否优先于栈顶操作符 ？ 直接入栈 ： 取栈顶操作符计算（特殊情况：栈顶左括号直接入栈）
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

            while (!ops.isEmpty() && !isPrior(c, ops.peek())) {
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

    private void fetchAndCalc(Stack<Integer> nums, Stack<Character> ops) {
        char op = ops.pop();
        int num2 = nums.pop();
        int num1 = nums.pop();

        int res = calc(num1, num2, op);
        nums.push(res);
    }

    private int calc(int num1, int num2, char op) {
        switch (op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
        }
        return -1;
    }


    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    // 优先级高的直接入栈，优先级低的拉栈顶元素计算
    private boolean isPrior(char a, char b) {
        if (b == '(') return true;
        return (a == '*' || a == '/') && (b == '+' || b == '-');
    }
}
