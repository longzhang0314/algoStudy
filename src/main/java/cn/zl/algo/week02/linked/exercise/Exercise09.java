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
        ListNode start = head;
        ListNode end = start;
        for (int i = 0; i < k - 1 && end != null; i++) {
            end = end.next;
        }
        if (end == null) return head;
        ListNode tmp = end.next;
        end.next = null;
        ListNode reverse = reverse(start);
        start.next = reverseKGroup(tmp, k);
        return reverse;
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        ListNode p = head;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = newHead;
            newHead = p;
            p = tmp;
        }
        return newHead;
    }


    // 非递归解法
    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) return head;
        ListNode p = head, newHead = head, prev = null;
        while (p != null) {
            ListNode end = p;
            for (int i = 0; i < k - 1 && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                if (prev != null) {
                    prev.next = p;
                }
                break;
            }
            ListNode tmp = end.next;
            end.next = null;
            ListNode reverse = reverse(p);
            if (prev != null) {
                prev.next = reverse;
            } else {
                newHead = reverse;
            }
            prev = p;
            p = tmp;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        Exercise09 e = new Exercise09();
        ListNode l = e.reverseKGroup2(head, 2);

    }


}
