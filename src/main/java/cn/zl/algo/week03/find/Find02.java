package cn.zl.algo.week03.find;

import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 *
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的算符包括+、-、*、/。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 *
 * 逆波兰表达式：
 *
 * 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
 *
 * 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
 * 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
 * 逆波兰表达式主要有以下两个优点：
 *
 * 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 * 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。
 *
 * @author: longzhang
 * @date: 2021/12/16
 */
public class Find02 {


    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> nums = new Stack<>();
        Stack<String> ops = new Stack<>();
        int i = 0, n = tokens.length;
        while (i < n) {
            if (isOps(tokens[i])) {
                fetchAndCalc(nums, tokens[i]);
            } else {
                nums.push(Integer.parseInt(tokens[i]));
            }
            i++;
        }
        return nums.pop();
    }

    private boolean isOps(String s) {
        return "+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s);
    }

    private void fetchAndCalc(Stack<Integer> nums, String ops) {
        int k2 = nums.pop();
        int k1 = nums.pop();
        switch (ops) {
            case "+":
                nums.push(k1 + k2);
                break;
            case "-":
                nums.push(k1 - k2);
                break;
            case "*":
                nums.push(k1 * k2);
                break;
            case "/":
                nums.push(k1 / k2);
                break;
            default:
        }
    }
}
