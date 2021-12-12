package cn.zl.algo.week02.linked.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * 141.环形链表（简单）
 * @author liusha
 * @date 2021/12/9
 */
public class Exercise13 {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    // fast初始化为fast.next
    public boolean hasCycle2(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow == fast) return true;
        return false;
    }
}
