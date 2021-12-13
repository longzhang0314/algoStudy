package cn.zl.algo.week03.exercise;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈（简单）
 *
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 *
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *
 * @author: longzhang
 * @date: 2021/12/13
 */
public class Exercise02 {
}

// 方法1：入队时倒腾，最新入队的在队首，出队时直接出队
class MyStack {

    private Queue<Integer> queue;
    private Queue<Integer> tmp;

    public MyStack() {
        this.queue = new LinkedList<>();
        this.tmp = new LinkedList<>();
    }

    public void push(int x) {
        while (!queue.isEmpty()) {
            tmp.offer(queue.poll());
        }
        queue.offer(x);
        while (!tmp.isEmpty()) {
            queue.offer(tmp.poll());
        }
    }

    public int pop() {
        if (queue.isEmpty()) return -1;
        return queue.poll();
    }

    public int top() {
        if (queue.isEmpty()) return -1;
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}


// 方法2：直接入队，出队时倒腾
class MyStack2 {

    private Queue<Integer> queue;
    private Queue<Integer> tmp;

    public MyStack2() {
        this.queue = new LinkedList<>();
        this.tmp = new LinkedList<>();
    }

    public void push(int x) {
       queue.offer(x);
    }

    public int pop() {
        if (queue.isEmpty()) return -1;
        while (queue.size() > 1) {
            tmp.offer(queue.poll());
        }
        int pop = queue.poll();
        while (!tmp.isEmpty()) {
            queue.offer(tmp.poll());
        }
        return pop;
    }

    public int top() {
        if (queue.isEmpty()) return -1;
        while (queue.size() > 1) {
            tmp.offer(queue.poll());
        }
        int pop = queue.poll();
        tmp.offer(pop);
        while (!tmp.isEmpty()) {
            queue.offer(tmp.poll());
        }
        return pop;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}


