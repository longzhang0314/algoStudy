package cn.zl.algo.week04.sort.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * 147. 对链表进行插入排序（中等）
 *
 * 对链表进行插入排序。
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 * TODO 重做练一遍
 * @author liusha
 * @date 2021/12/21
 */
public class Exercise08 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0);
        ListNode tail = newHead;
        int cnt = 0;
        ListNode p = head;
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
            // 找插入点
            ListNode q = newHead;
            while (q.next != null && q.next.val <= p.val) {
                q = q.next;
            }
            p.next = q.next;
            q.next = p;

            p = tmp;
        }
        return newHead.next;
    }
}
