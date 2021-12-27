package cn.zl.algo.week04.sort.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * @author: longzhang
 * @date: 2021/12/27
 */
public class Exercise09Test {

    // 递归写法
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = findMid(head);
        ListNode tmp = mid.next;
        mid.next = null;
        ListNode l1 = mergeSort(head);
        ListNode l2 = mergeSort(tmp);
        return merge(l1, l2);
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;

        return newHead.next;
    }

}
