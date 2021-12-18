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
 * 【注意】两个队列优化解法、一个队列优化解法（两种）
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

// 方法3：出队时倒腾优化解法
class MyStack3 {

    private Queue<Integer> queue;
    private Queue<Integer> tmp;

    // 优化解法：
    public MyStack3() {
        this.queue = new LinkedList<>();
        this.tmp = new LinkedList<>();
    }

    public void push(int x) {
        if (tmp.isEmpty()) {
            queue.offer(x);
        } else {
            tmp.offer(x);
        }
    }

    public int pop() {
        if (empty()) return -1;
        if (queue.isEmpty()) {
            while (tmp.size() > 1) {
                queue.offer(tmp.poll());
            }
            return tmp.poll();
        } else {
            while (queue.size() > 1) {
                tmp.offer(queue.poll());
            }
            return queue.poll();
        }
    }

    public int top() {
        if (empty()) return -1;
        int top;
        if (queue.isEmpty()) {
            while (tmp.size() > 1) {
                queue.offer(tmp.poll());
            }
            top = tmp.poll();
            queue.offer(top);
        } else {
            while (queue.size() > 1) {
                tmp.offer(queue.poll());
            }
            top = queue.poll();
            tmp.offer(top);
        }
        return top;
    }

    public boolean empty() {
        return queue.isEmpty() && tmp.isEmpty();
    }
}

// 方法4：出队时倒腾【1个队列】优化解法
class MyStack4 {

    private Queue<Integer> queue;


    // 优化解法：
    public MyStack4() {
        this.queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        if (empty()) return -1;
        int size = queue.size();
        while (size > 1) {
            queue.offer(queue.poll());
            size--;
        }
        return queue.poll();
    }

    public int top() {
        if (empty()) return -1;
        int size = queue.size();
        while (size > 1) {
            queue.offer(queue.poll());
            size--;
        }
        int top = queue.poll();
        queue.offer(top);
        return top;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

// 方法5：入队时倒腾【1个队列】优化解法
class MyStack5 {

    private Queue<Integer> queue;

    // 优化解法：
    public MyStack5() {
        this.queue = new LinkedList<>();
    }

    public void push(int x) {
        int size = queue.size();
        queue.offer(x);
        while (size > 0) {
            queue.offer(queue.poll());
            --size;
        }

    }

    public int pop() {
        if (empty()) return -1;
        return queue.poll();
    }

    public int top() {
        if (empty()) return -1;
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

