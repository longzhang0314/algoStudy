package two.week02;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * @author liusha
 * @date 2022/5/25
 */
public class Example04Test2 {

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                ListNode next = l1.next;
                p.next = l1;
                l1 = next;
            } else {
                ListNode next = l2.next;
                p.next = l2;
                l2 = next;
            }
            p = p.next;
        }

        if (l1 != null) {
            p.next = l1;
        } else {
            p.next = l2;
        }

        return newHead.next;
    }
}
