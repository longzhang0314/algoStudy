package cn.zl.algo.week03.example;

import java.util.Stack;

/**
 * 用栈实现队列（字节实习，出处）
 *
 * @author liusha
 * @date 2021/12/13
 */
public class Example01 {
}

/**
 * 实现1：入队时直接入栈，出队时捣腾
 */
class Queue {
    private Stack<Integer> stack;
    private Stack<Integer> tmp;

    public Queue() {
        this.stack = new Stack<>();
        this.tmp = new Stack<>();
    }

    public void enqueue(int val) {
        stack.push(val);
    }

    public int dequeue() {
        if (stack.isEmpty()) return -1;
        while (!stack.isEmpty()) {
            tmp.push(stack.pop());
        }
        int val = tmp.pop();
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
        return val;
    }

    public int peek() {
        if (isEmpty()) return -1;
        while (!stack.isEmpty()) {
            tmp.push(stack.pop());
        }
        int val = tmp.peek();
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
        return val;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

}

/**
 * 实现2
 */
class Queue2 {

    private Stack<Integer> stack;
    private Stack<Integer> tmp;

    public Queue2() {
        this.stack = new Stack<>();
        this.tmp = new Stack<>();
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

    public boolean isEmpty() {
        return stack.isEmpty();
    }


}
