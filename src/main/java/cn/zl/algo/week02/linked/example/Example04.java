package cn.zl.algo.week02.linked.example;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * 例题4 剑指 Offer 25. 合并两个排序的链表
 */
public class Example04 {

    // 方法1：新链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                ListNode tmp = l1.next;
                p.next = l1;
                l1.next = null;
                l1 = tmp;
                p = p.next;
            } else {
                ListNode tmp = l2.next;
                p.next = l2;
                l2.next = null;
                l2 = tmp;
                p = p.next;
            }
        }
        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return newHead.next;
    }

    // 方法2：原链表上捣腾 TODO
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        return null;
    }
}
