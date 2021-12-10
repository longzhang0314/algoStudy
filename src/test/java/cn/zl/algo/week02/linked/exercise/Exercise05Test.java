package cn.zl.algo.week02.linked.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * @author liusha
 * @date 2021/12/10
 */
public class Exercise05Test {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (l1 != null && l2 != null) {
            int sum = carry + l1.val + l2.val;
            carry = sum / 10;
            sum %= 10;
            p.next = new ListNode(sum);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l2 != null) l1 = l2;
        while (l1 != null) {
            int sum = carry + l1.val;
            carry = sum / 10;
            sum %= 10;
            p.next = new ListNode(sum);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            p.next = new ListNode(carry);
        }
        return head.next;
    }
}
