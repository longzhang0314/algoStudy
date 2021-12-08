package cn.zl.algo.week02.linked.example;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * 例题2 203.移除链表元素（简单）
 */
public class Example02 {

    // 虚拟头结点优化
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = newHead;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return newHead.next;
    }

    // 无需虚拟头结点
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) return null;
        ListNode p = head;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }

    // 插入新链表
    public ListNode removeElements3(ListNode head, int val) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0);
        ListNode q = newHead;

        ListNode p = head;
        while (p != null) {
            ListNode tmp = p.next;
            if (p.val != val) {
                q.next = p;
                p.next = null;
                q = q.next;
            }
            p = tmp;
        }
        return newHead.next;
    }
}
