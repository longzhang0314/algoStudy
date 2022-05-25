package two.week02;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * @author liusha
 * @date 2022/5/25
 */
public class Exercise05Test2 {


    /**
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     *
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode newHead = new ListNode(0);
        ListNode p = newHead;

        int carry = 0;
        while (l1 != null || l2 != null) {
            carry = carry + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            p.next = new ListNode(carry % 10);
            carry /= 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            p = p.next;
        }

        if (carry != 0) {
            p.next = new ListNode(carry);
        }

        return newHead.next;
    }
}
