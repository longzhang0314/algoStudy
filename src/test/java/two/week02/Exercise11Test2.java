package two.week02;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * @author liusha
 * @date 2022/5/31
 */
public class Exercise11Test2 {

    // 12345,2  -> 1235
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) return head;
        // 快指针先走k步，然后快慢指针一起走，快指针走到最后一个节点时，慢指针所在位置就是待删除的前一个节点；头节点特殊处理
        // 例如,倒数第1，倒数第2，倒数第5，倒数第（大于5）
        ListNode slow = head, fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
            if (fast == null) break;
        }
        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }


        slow.next = slow.next.next;
        return head;
    }
}
