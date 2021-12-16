package cn.zl.algo.week03.addition;

/**
 * 641. 设计循环双端队列（中等）
 *
 * 设计实现双端队列。
 * 你的实现需要支持以下操作：
 *
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 *
 * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
 * circularDeque.insertLast(1);			        // 返回 true
 * circularDeque.insertLast(2);			        // 返回 true
 * circularDeque.insertFront(3);			        // 返回 true
 * circularDeque.insertFront(4);			        // 已经满了，返回 false
 * circularDeque.getRear();  				// 返回 2
 * circularDeque.isFull();				        // 返回 true
 * circularDeque.deleteLast();			        // 返回 true
 * circularDeque.insertFront(4);			        // 返回 true
 * circularDeque.getFront();				// 返回 4
 *
 * @author: longzhang
 * @date: 2021/12/16
 */
public class Addition01 {
}

class MyCircularDeque {

    private int n;
    private int[] arr;
    private int head;
    private int tail;

    public MyCircularDeque(int k) {
        this.n = k + 1;
        this.head = 0;
        this.tail = 0;
        this.arr = new int[n];
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        head = (head - 1 + n) % n;
        arr[head] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        arr[tail] = value;
        tail = (tail + 1) % n;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        head = (head + 1) % n;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        tail = (tail - 1 + n) % n;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return arr[head];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        int idx = (tail - 1 + n) % n;
        return arr[idx];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return (tail + 1) % n == head;
    }
}
