package two.week02;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * @author liusha
 * @date 2022/5/30
 */
public class Exercise06Test2 {

    // 原地
    public ListNode reverseList1(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        return pre;
    }


    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // 头插
    public ListNode reverseList3(ListNode head) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0);
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;

            p.next = newHead.next;
            newHead.next = p;

            p = next;
        }
        return newHead.next;
    }


}
