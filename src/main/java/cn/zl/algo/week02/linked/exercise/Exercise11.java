package cn.zl.algo.week02.linked.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * 19.删除链表的倒数第n个节点（中等）
 *
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
        if (head == null || n <= 0) return head;
        // 找到倒数第n个节点的前置节点
        // 快慢指针，快指针先走到第n步，但要注意是否走到结尾
        ListNode fast = head;
        for (int i = 0; i < n - 1 && fast != null; i++) {
            fast = fast.next;
        }
        // 走到null了说明n太大不合理
        if (fast == null) return head;
        if (fast.next == null) { // 删除头节点
            head = head.next;
            return head;
        }
        ListNode slow = head;
        // 由于要找到倒数第n的前置节点，所以fast最终只能停留在倒数第2个位置
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

}
