package cn.zl.algo.week03.exercise;

import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列（简单）（已讲）
 *
 *  【注意】优化解法
 * @author: longzhang
 * @date: 2021/12/13
 */
public class Exercise01 {

}

// 优化解法：出栈时倒腾到tmp以后不再倒腾回去
class CQueue2 {

    private Stack<Integer> stack;
    private Stack<Integer> tmp;

    public CQueue2() {
        this.stack  = new Stack<>();
        this.tmp = new Stack<>();
    }

    public void appendTail(int value) {
        stack.push(value);
    }

    public int deleteHead() {
        if (isEmpty()) return -1;
        if (!tmp.isEmpty()) return tmp.pop();
        while (!stack.isEmpty()) {
            tmp.push(stack.pop());
        }
        return tmp.pop();
    }

    private boolean isEmpty() {
        return stack.isEmpty() && tmp.isEmpty();
    }
}


class CQueue {

    private Stack<Integer> stack;
    private Stack<Integer> tmp;

    public CQueue() {
        this.stack  = new Stack<>();
        this.tmp = new Stack<>();
    }

    public void appendTail(int value) {
        while (!stack.isEmpty()) {
            tmp.push(stack.pop());
        }
        stack.push(value);
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
    }

    public int deleteHead() {
        if (stack.isEmpty()) return -1;
        return stack.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
