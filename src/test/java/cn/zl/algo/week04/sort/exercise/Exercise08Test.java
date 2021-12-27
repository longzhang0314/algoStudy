package cn.zl.algo.week04.sort.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * @author liusha
 * @date 2021/12/27
 */
public class Exercise08Test {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0);
        ListNode p = head;
        while (p != null) {
            ListNode tmp = p.next;
            ListNode q = newHead;
            while (q.next != null && q.next.val > p.val) {
                q = q.next;
            }
            p.next = q.next;
            q.next = p;
            p = tmp;
        }
        return newHead.next;
    }
}
