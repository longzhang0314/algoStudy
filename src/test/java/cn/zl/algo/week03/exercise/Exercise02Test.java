package cn.zl.algo.week03.exercise;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liusha
 * @date 2021/12/15
 */
public class Exercise02Test {
}


// 队列实现栈
class MyStack {

    private Queue<Integer> queue;
    private Queue<Integer> tmp;

    public MyStack() {
        this.queue = new LinkedList<>();
        this.tmp = new LinkedList<>();
    }

    public void push(int val) {
        // 入队捣腾, 也可以出队捣腾
        while (!queue.isEmpty()) {
            tmp.offer(queue.poll());
        }
        queue.offer(val);
        while (!tmp.isEmpty()) {
            queue.offer(tmp.poll());
        }
    }

    public int pop() {
        if (isEmpty()) return -1;
        return queue.poll();
    }

    public int top() {
        if (isEmpty()) return -1;
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // =============================================

    // 出队捣腾专门的方法
    public int pop2() {
        if (isEmpty()) return -1;
        while (queue.size() > 1) {
            tmp.offer(queue.poll());
        }
        int pop = queue.poll();
        while (!tmp.isEmpty()) {
            queue.offer(tmp.poll());
        }
        return pop;
    }



}
