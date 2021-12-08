package cn.zl.algo.week02.linked.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * 206.反转链表（中等，阿里云存储22届暑期实习，出处）
 */
public class Exercise06 {

    // 方法1：原链表上捣腾
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    // 方法2：原链表上递归捣腾
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    // 方法3：头插法形成新链表
    public ListNode reverseList3(ListNode head) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0);
        ListNode p = head;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = newHead.next;
            newHead.next = p;
            p = tmp;
        }
        return newHead.next;
    }
}
