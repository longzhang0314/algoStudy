package cn.zl.algo.week02.linked.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * 25. K 个一组翻转链表（困难）
 * @author: longzhang
 * @date: 2021/12/8
 *
 * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 * k是一个正整数，它的值小于或等于链表的长度。
 *
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class Exercise09 {


    /**
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[2,1,4,3,5]
     *
     * @param head
     * @param k
     * @return
     */
    // 方法1：先翻转k个，然后递归翻转后面的节点
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        // 先反转前k个，然后递归反转后面的
        ListNode start = head;
        ListNode end = start;
        for (int i = 0; i < k - 1; i++) {
            if (end == null) break;
            end = end.next;
        }
        if (end == null) return start;
        ListNode tmp = end.next;
        ListNode newHead = reverse(start, end.next);
        start.next = reverseKGroup(tmp, k);
        return newHead;
    }
    private ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode p = start;
        while (p != end) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return prev;
    }

}
