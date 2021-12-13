package cn.zl.algo.week02.linked.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * @author: longzhang
 * @date: 2021/12/12
 */
public class Exercise06Test {

    public ListNode reverseList(ListNode head) {
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
}
