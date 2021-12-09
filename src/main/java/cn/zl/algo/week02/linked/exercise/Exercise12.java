package cn.zl.algo.week02.linked.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * 160.相交l链表（简单）
 * @author liusha
 * @date 2021/12/9
 */
public class Exercise12 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        int m = 0, n = 0;
        while (a != null) {
            m++;
            a = a.next;
        }
        while (b != null) {
            n++;
            b = b.next;
        }
        ListNode shorter, longer;
        if (m <= n) {
            shorter = headA;
            longer = headB;
        } else {
            shorter = headB;
            longer = headA;
        }
        int sub = Math.abs(m - n);
        // longer提前走sub步
        for (int i = 0; i < sub; i++) {
            longer = longer.next;
        }
        while (shorter != null) {
            if (shorter == longer) return shorter;
            shorter = shorter.next;
            longer = longer.next;
        }
        return null;
    }
}
