package cn.zl.algo.week03.common;


/**
 * 基于链表实现栈
 * @author: longzhang
 * @date: 2021/12/12
 */
public class LinkedListStack {

    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head;

    public LinkedListStack() {
    }

    public boolean push(int num) {
        Node node = new Node(num);
        node.next = head;
        head = node;
        return true;
    }

    public int pop() {
        if (isEmpty()) return -1;
        int val = head.val;
        head = head.next;
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
