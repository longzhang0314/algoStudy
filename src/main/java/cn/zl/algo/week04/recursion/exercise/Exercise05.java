package cn.zl.algo.week04.recursion.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * 剑指Offer 24 反转链表（简单）
 * @author liusha
 * @date 2021/12/20
 */
public class Exercise05 {


    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


    public ListNode reverseList2(ListNode head) {
        if (head == null) return null;
        ListNode newHead = null;
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;
            p.next = newHead;
            newHead = p;
            p = next;
        }
        return newHead;
    }



}
