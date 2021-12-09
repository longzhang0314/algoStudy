package cn.zl.algo.week02.linked;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * 234. 回文链表（中等）
 *
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */
public class Exercise07 {

    // 方法1：找到中点，然后反转后半部分元素，和前半部分元素比较
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        // 找中点 偶数为后一个中点
        ListNode mid = findMid(head);
        ListNode qPrev = null, q = mid;
        // q到结束的链表翻转
        while (q != null) {
            ListNode next = q.next;
            q.next = qPrev;
            qPrev = q;
            q = next;
        }
        ListNode p = head;
        while (qPrev != null && p != null) {
            if (qPrev.val != p.val) return false;
            qPrev = qPrev.next;
            p = p.next;
        }
        return true;
    }
    private ListNode findMid(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
