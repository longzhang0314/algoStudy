package cn.zl.algo.week02.linked.addition;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * 24. 两两交换链表中的节点（中等）(覃超)
 *
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * TODO 第三周练习
 * @author: longzhang
 * @date: 2021/12/11
 */
public class Addition01 {

    /**
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     *
     * @param head
     * @return
     */
    // 方法1：递归实现
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        // 交换两个，递归处理
        ListNode l1 = head, l2 = head.next;
        ListNode tmp = l2.next;
        l2.next = l1;
        head = l2;
        l1.next = swapPairs(tmp);
        return head;
    }

    // 方法2：非递归
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p1 = head;
        ListNode newHead = head.next;
        ListNode prev = null;
        while (p1 != null && p1.next != null) {
            ListNode p2 = p1.next;
            ListNode next = p2.next;

            p2.next = p1;
            p1.next = null;
            if (prev != null) {
                prev.next = p2;
            }

            prev = p1;
            p1 = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        Addition01 a = new Addition01();
        ListNode l = a.swapPairs2(head);
        while (l != null) {
            System.out.println(l);
            l = l.next;
        }
    }
}
