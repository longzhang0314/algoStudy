package cn.zl.algo.week03.exercise;

import java.util.Stack;

/**
 * 155. 最小栈（简单）
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop()—— 删除栈顶的元素。
 * top()—— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * 【注意】可以1个栈实现
 * @author: longzhang
 * @date: 2021/12/13
 */
public class Exercise04 {
}

// 方法1：一个普通栈，一个最小栈存储当前最小元素
class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> min;

    public MinStack() {
        this.stack = new Stack<>();
        this.min = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        min.push(min.isEmpty() ? val : Math.min(min.peek(), val));
    }

    public void pop() {
        if (stack.isEmpty()) return;
        stack.pop();
        min.pop();
    }

    public int top() {
        if (stack.isEmpty()) return -1;
        return stack.peek();
    }

    public int getMin() {
        if (stack.isEmpty()) return -1;
        return min.peek();
    }
}

// 方法2：一个栈实现，先push val,然后push min
class MinStack2 {

    private Stack<Integer> stack;

    public MinStack2() {
        this.stack = new Stack<>();
    }

    public void push(int val) {
        int min = Math.min(stack.isEmpty() ? Integer.MAX_VALUE : stack.peek(), val);
        stack.push(val);
        stack.push(min);
    }

    public void pop() {
        if (stack.isEmpty()) return;
        stack.pop();
        stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) return -1;
        int min = stack.pop();
        int top = stack.peek();
        stack.push(min);
        return top;
    }

    public int getMin() {
        if (stack.isEmpty()) return -1;
        return stack.peek();
    }
}
