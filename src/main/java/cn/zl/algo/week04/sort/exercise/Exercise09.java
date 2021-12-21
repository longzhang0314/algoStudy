package cn.zl.algo.week04.sort.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * 148. 排序链表（中等）
 *
 * @author liusha
 * @date 2021/12/21
 */
public class Exercise09 {


    // 方法1：归并 O(N^logN)
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == tail) return head;
        ListNode min = getMin(head, tail);
        ListNode minNext = min.next;
        min.next = null;
        ListNode l1 = sortList(head, min);
        ListNode l2 = sortList(minNext, tail);
        return merge(l1, l2);
    }

    private ListNode getMin(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail && fast.next.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;

        return newHead.next;
    }


    // 方法2：快排 O(N^2) 不建议
    public ListNode sortList2(ListNode head) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0);
        ListNode tail = newHead;
        ListNode p = head;
        int cnt = 0;
        while (p != null) {
            cnt++;
            ListNode tmp = p.next;
            if (cnt == 1 || tail.val <= p.val) {
                tail.next = p;
                tail = tail.next;
                p.next = null;
                p = tmp;
                continue;
            }

            ListNode q = newHead;
            while (q.next != null && q.next.val < p.val) {
                q = q.next;
            }
            p.next = q.next;
            q.next = p;
            p = tmp;
        }
        return newHead.next;
    }



}
