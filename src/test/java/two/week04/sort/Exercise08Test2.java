package two.week04.sort;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * @author liusha
 * @date 2022/8/8
 */
public class Exercise08Test2 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode resHead = new ListNode(0);

        ListNode pre = newHead;
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;
            pre.next = next;
            p.next = null;

            if (resHead.next == null) {
                resHead.next = p;
            } else {
                ListNode q = resHead;
                while (q.next != null && q.next.val < p.val) {
                    q = q.next;
                }
                // 插在q.next之前
                p.next = q.next;
                q.next = p;
            }

            p = next;
        }
        return resHead.next;
    }
}
