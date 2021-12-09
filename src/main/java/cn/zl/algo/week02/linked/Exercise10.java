package cn.zl.algo.week02.linked;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点（简单）
 * @author: longzhang
 * @date: 2021/12/9
 *
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 */
public class Exercise10 {

    // 快慢指针
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) return head;
        // 假设k不大于链表长度，是有效数字
        // 快指针先走到正数第k个位置，然后快慢指针同时走，快指针走到最后一位时慢指针的位置
        ListNode fast = head;
        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
            // k超过了链表长度
            if (fast == null) return head;
        }
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
