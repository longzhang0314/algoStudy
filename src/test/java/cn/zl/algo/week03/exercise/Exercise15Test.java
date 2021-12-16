package cn.zl.algo.week03.exercise;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: longzhang
 * @date: 2021/12/16
 */
public class Exercise15Test {
}

class MaxQueue {

    private Queue<Integer> queue;
    private Deque<Integer> max;

    public MaxQueue() {
        this.queue = new LinkedList<>();
        this.max = new LinkedList<>();
    }

    public int max_value() {
        if (queue.isEmpty()) return -1;
        return max.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!max.isEmpty() && max.peekLast() < value) {
            max.pollLast();
        }
        max.offerLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        int pop = queue.poll();
        if (pop == max.peekFirst()) {
            max.pollFirst();
        }
        return pop;
    }
}