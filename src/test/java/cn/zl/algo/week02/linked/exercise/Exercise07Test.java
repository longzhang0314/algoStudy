package cn.zl.algo.week02.linked.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * @author liusha
 * @date 2021/12/10
 */
public class Exercise07Test {

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        // next mid
        ListNode min = findMin(head);
        ListNode reverse = reverse(min);
        ListNode p = head;
        while (p != null && reverse != null) {
            if (p.val != reverse.val) return false;
            p = p.next;
            reverse = reverse.next;
        }
        return true;
    }

    private ListNode findMin(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode min) {
        if (min == null) return null;
        ListNode prev = null;
        ListNode p = min;
        while (p != null) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return prev;
    }
}
