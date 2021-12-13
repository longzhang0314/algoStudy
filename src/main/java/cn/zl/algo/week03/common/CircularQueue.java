package cn.zl.algo.week03.common;

/**
 * 基于数组实现循环队列
 *
 * @author: longzhang
 * @date: 2021/12/12
 */
public class CircularQueue {

    public int head;
    public int tail;
    public int n;
    public int[] arr;

    // 构建真实容量为n的队列
    public CircularQueue(int n) {
        this.head = 0;
        this.tail = 0;
        this.n = n + 1;
        // 空出一个位置，方便区分判断队列空和满
        this.arr = new int[n + 1];
    }

    public boolean enqueue(int num) {
        if (isFull()) return false;
        arr[tail] = num;
        tail = (tail + 1) % n;
        return true;
    }

    public int dequeue() {
        if (isEmpty()) return -1;
        int val = arr[head];
        head = (head + 1) % n;
        return val;
    }

    public int peek() {
        if (isEmpty()) return -1;
        return arr[head];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    private boolean isFull() {
        return (tail + 1) % n == head;
    }



}
