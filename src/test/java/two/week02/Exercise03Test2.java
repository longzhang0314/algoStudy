package two.week02;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * @author liusha
 * @date 2022/5/25
 */
public class Exercise03Test2 {

    public ListNode deleteDuplicates(ListNode head) {
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
