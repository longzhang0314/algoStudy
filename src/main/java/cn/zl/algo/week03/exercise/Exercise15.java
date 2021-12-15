package cn.zl.algo.week03.exercise;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 59 - II. 队列的最大值（中等） 单调队列
 *
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value需要返回 -1
 *
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * TODO 【注意】思路,及证明可行
 * @author: longzhang
 * @date: 2021/12/14
 */
public class Exercise15 {
}

// 一个额外的双端队列，队首存储当前队列的最大值
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
        int poll = queue.poll();
        if (poll == max.peekFirst()) {
            max.pollFirst();
        }
        return poll;
    }
}
