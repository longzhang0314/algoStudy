package cn.zl.algo.week02.linked.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * 83.删除排序链表中的重复元素（简单）
 */
public class Exercise03 {

    /**
     * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
     * 返回同样按升序排列的结果链表。
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode p = head;
        while (p.next != null) {
            if (p.val == p.next.val) {
                // 删除p.next
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }

    // 方法2：新开一个链表头节点，不重复的挪移过来
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0);
        ListNode tail = newHead;
        ListNode p = head;
        int cnt = 0;
        while (p != null) {
            ListNode tmp = p.next;
            if (cnt == 0 || tail.val != p.val) {
                tail.next = p;
                tail = tail.next;
                cnt++;
            }
            p = tmp;
        }
        tail.next = null;
        return newHead.next;
    }

}
