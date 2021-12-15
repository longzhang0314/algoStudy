package cn.zl.algo.week03.exercise;

import java.util.Stack;

/**
 * @author liusha
 * @date 2021/12/15
 */
public class Exercise04Test {
}

/**
 * * 155. 最小栈（简单）
 *  *
 *  * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *  *
 *  * push(x) —— 将元素 x 推入栈中。
 *  * pop()—— 删除栈顶的元素。
 *  * top()—— 获取栈顶元素。
 *  * getMin() —— 检索栈中的最小元素。
 */
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min;

    public MinStack() {
        this.stack = new Stack<>();
        this.min = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (!min.isEmpty() && min.peek() < val) {
            min.push(min.peek());
        } else {
            min.push(val);
        }
    }

    public int pop() {
        min.pop();
        return stack.pop();
    }


    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }

}
