package cn.zl.algo.week03.common;

/**
 * 基于链表实现无界队列
 *
 * 链表尾部添加元素，头部删除（因为尾部删除O(N)）
 * @author: longzhang
 * @date: 2021/12/12
 */
public class LinkedListQueue {

    private static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;

    public LinkedListQueue(){}

    public boolean enqueue(int num) {
        Node node = new Node(num);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
        return true;
    }

    public int dequeue() {
        if (isEmpty()) return -1;
        int val = head.val;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return val;
    }

    public int peek() {
        if (isEmpty()) return -1;
        return head.val;
    }

    public boolean isEmpty() {
        return head == null;
    }

}
