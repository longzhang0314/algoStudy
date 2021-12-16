package cn.zl.algo.week02.linked.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * @author liusha
 * @date 2021/12/16
 */
public class Exercise03Test {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = newHead;
        while (p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return newHead.next;
    }
}
