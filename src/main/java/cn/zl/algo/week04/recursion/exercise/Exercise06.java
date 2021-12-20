package cn.zl.algo.week04.recursion.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * 剑指Offer 25 合并两个排序的链表（中等）
 *
 * @author liusha
 * @date 2021/12/20
 */
public class Exercise06 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;
        if (l1.val <= l2.val) {
            ListNode next = l1.next;
            p.next = l1;
            l1.next = null;
            p = p.next;
            p.next = mergeTwoLists(next, l2);
        } else {
            ListNode next = l2.next;
            p.next = l2;
            l2.next = null;
            p = p.next;
            p.next = mergeTwoLists(l1, next);
        }
        return newHead.next;
    }

}
