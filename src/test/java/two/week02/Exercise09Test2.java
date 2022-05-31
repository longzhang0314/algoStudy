package two.week02;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * @author liusha
 * @date 2022/5/31
 */
public class Exercise09Test2 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        ListNode newHead = new ListNode(0);
        ListNode p = head;
        // 前一轮k个翻转后的尾部节点
        ListNode preTail = newHead;

        while (p != null) {
            // 判断是否有k个，没有不反转
            int cnt = 0;
            ListNode q = p;
            while (q != null) {
                cnt++;
                q = q.next;
            }
            if (cnt < k) {
                preTail.next = p;
                break;
            }


            // 本轮翻转后的尾部节点
            ListNode curTail = p;
            // 本轮翻转后的头部节点
            ListNode curHead = null;

            ListNode pre = null;

            for (int i = 0; i < k; i++) {
                curHead = p;
                ListNode next = p.next;
                p.next = pre;
                pre = p;
                p = next;
            }

            preTail.next = curHead;
            preTail = curTail;
        }
        return newHead.next;
    }
}
