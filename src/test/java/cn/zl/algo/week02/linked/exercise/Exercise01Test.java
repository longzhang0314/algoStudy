package cn.zl.algo.week02.linked.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * @author liusha
 * @date 2021/12/16
 */
public class Exercise01Test {


    // 移除值为val的元素
    // 直接遍历，特殊处理头结点
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }

    // 哨兵优化
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = newHead;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return newHead.next;
    }
}
