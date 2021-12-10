package cn.zl.algo.week02.linked.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * 2.两数相加（中等，腾讯WXG21届秋招，出处）
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class Exercise05 {

    /**
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     *
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int val1 = l1.val;
            int val2 = l2.val;
            int sum = val1 + val2 + carry;
            int cur = sum % 10;
            carry = sum / 10;
            p.next = new ListNode(cur);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        // 统一用l1进行处理
        if (l2 != null) l1 = l2;
        while (l1 != null) {
            int sum = l1.val + carry;
            int cur = sum % 10;
            carry = sum / 10;
            p.next = new ListNode(cur);
            p = p.next;
            l1 = l1.next;
        }
        if (carry != 0) {
            p.next = new ListNode(carry);
        }
        return newHead.next;
    }
}
