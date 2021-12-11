package cn.zl.algo.week02.linked.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * 234. 回文链表（中等）
 *
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */
public class Exercise07 {
    private ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode p = head.next;
        head.next = null;
        while (p != null) {
            ListNode next = p.next;
            p.next = head;
            head = p;
            p = next;
        }
        return head;
    }

    // 方法1：找到中点，然后反转后半部分元素，和前半部分元素比较
    // 前一个中间节点
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        // 获取前一个中间节点
        ListNode min = findMin(head);
        // revers [min.next, null)
        ListNode q = reverse(min.next);
        ListNode p = head;
        while (q != null) {
            if (p.val != q.val) return false;
            p = p.next;
            q = q.next;
        }
        return true;
    }
    private ListNode findMin(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // =========================================================================================================

    // 获取后一个中间节点，也可以
    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) return true;
        // 获取后一个中间节点
        ListNode min = findMin2(head);
        // revers [min, null)
        ListNode q = reverse(min);
        ListNode p = head;
        while (q != null) {
            if (p.val != q.val) return false;
            p = p.next;
            q = q.next;
        }
        return true;
    }
    private ListNode findMin2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
