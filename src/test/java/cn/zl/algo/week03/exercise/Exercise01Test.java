package cn.zl.algo.week03.exercise;

import java.util.Stack;

/**
 * 练习：两个栈实现队列
 * @author liusha
 * @date 2021/12/15
 */
public class Exercise01Test {
}

// 入队、出队、是否为空
// 方法1：入队捣腾，直接出队
class CQueue {

    private Stack<Integer> stack;
    private Stack<Integer> tmp;

    public CQueue() {
        this.stack = new Stack<>();
        this.tmp = new Stack<>();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void enqueue(int val) {
        while (!stack.isEmpty()) {
            tmp.push(stack.pop());
        }
        stack.push(val);
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
    }

    public int dequeue() {
        if (isEmpty()) return -1;
        return stack.pop();
    }

    public int peek() {
        if (isEmpty()) return -1;
        return stack.peek();
    }
}

class CQueue1 {

    private Stack<Integer> stack;
    private Stack<Integer> tmp;

    public CQueue1() {
        this.stack = new Stack<>();
        this.tmp = new Stack<>();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void enqueue(int val) {
        stack.push(val);
    }

    public int dequeue() {
        if (isEmpty()) return -1;
        while (!stack.isEmpty()) {
            tmp.push(stack.pop());
        }
        int pop = tmp.pop();
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
        return pop;
    }

    public int peek() {
        if (isEmpty()) return -1;
        while (!stack.isEmpty()) {
            tmp.push(stack.pop());
        }
        int peek = tmp.peek();
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
        return peek;
    }
}


