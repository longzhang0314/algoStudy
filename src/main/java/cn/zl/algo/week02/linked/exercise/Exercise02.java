package cn.zl.algo.week02.linked.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * 203. 链表的中间节点（简单）（已讲）
 */
public class Exercise02 {

    // 方法1：快慢指针
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 方法2：提前计数
    public ListNode middleNode2(ListNode head) {
        if (head == null) return null;
        int cnt = 0;
        ListNode p = head;
        while (p != null) {
            cnt++;
            p = p.next;
        }
        // 从第一个开始走move步
        int move = cnt / 2;
        p = head;
        for (int i = 0; i < move; i++) {
            p = p.next;
        }
        return p;
    }



}
