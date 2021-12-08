package cn.zl.algo.week02.linked.example;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * 例题3 876.链表的中间节点（简单）
 *
 * 奇数个中间，偶数个中间靠后
 */
public class Example03 {

    // 快慢指针
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 提前计数
    public ListNode middleNode2(ListNode head) {
        if (head == null) return null;
        int cnt = 0;
        ListNode p = head;
        while (p != null) {
            cnt++;
            p = p.next;
        }
        int n = cnt / 2 + 1;
        p = head;
        cnt = 0;
        while (p != null) {
            cnt++;
            if (cnt == n) return p;
            p = p.next;
        }
        return null;
    }
}