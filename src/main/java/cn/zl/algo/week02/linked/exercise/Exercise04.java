package cn.zl.algo.week02.linked.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * 剑指 Offer 25. 合并两个排序的链表（中等）（已讲）
 */
public class Exercise04 {


    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode newHead = new ListNode(0);
        ListNode q = newHead;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                q.next = p1;
                p1 = p1.next;
            } else {
                q.next = p2;
                p2 = p2.next;
            }
            q = q.next;
        }
        if (p1 != null) q.next = p1;
        if (p2 != null) q.next = p2;
        return newHead.next;
    }
}
