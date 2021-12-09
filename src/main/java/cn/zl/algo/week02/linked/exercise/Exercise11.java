package cn.zl.algo.week02.linked.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * 19.删除链表的倒数第n个节点（中等）
 *
 * TODO 不熟练，先走几步的问题，再练
 * @author liusha
 * @date 2021/12/9
 */
public class Exercise11 {

    /**
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     *
     * 进阶：你能尝试使用一趟扫描实现吗？
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) return null;
        // 先找到倒数第n + 1步
        // 快指针先走n步,到第n+1个的位置
        ListNode fast = head;
        // n步
        for (int i = 0; i < n; i++) {
            if (fast == null) return head;
            fast = fast.next;
        }
        if (fast == null) return head.next;
        // 慢指针开始走,快指针走到null为止
        ListNode slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

}
