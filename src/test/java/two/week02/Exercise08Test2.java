package two.week02;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * @author liusha
 * @date 2022/5/30
 */
public class Exercise08Test2 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(0);
        ListNode odd = oddHead;
        ListNode even = evenHead;
        ListNode p = head;

        int i = 1;
        while (p != null) {
            if ((i & 1) == 1) {
                odd.next = p;
                odd = odd.next;
            } else {
                even.next = p;
                even = even.next;
            }
            p = p.next;
            i++;
        }
        odd.next = evenHead.next;
        return oddHead.next;
    }
}
