package cn.zl.algo.week02.linked.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * 203. 移除链表元素（简单）（已讲）
 */
public class Exercise01 {

    // 方法1：直接遍历，特殊处理头结点
    public ListNode removeElements(ListNode head, int val) {
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

    // 方法2：虚拟头结点优化
    public ListNode removeElements2(ListNode head, int val) {
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

    // 方法3：不相等元素移到
    public ListNode removeElements3(ListNode head, int val) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            if (cur.val != val) {
                p.next = cur;
                p = p.next;
                cur.next = null;
            }
            cur = tmp;
        }
        return newHead.next;
    }



}
