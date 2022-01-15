package cn.zl.algo.week07.heap.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表(困难) （已讲）
 * @author liusha
 * @date 2022/1/15
 */
public class Exercise01 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int k = lists.length;
        ListNode newHead = new ListNode(0);
        ListNode tail = newHead;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < k; i++) {
            ListNode cur = lists[i];
            if (cur == null) continue;
            heap.offer(cur);
        }

        while (!heap.isEmpty()) {
            ListNode top = heap.poll();
            ListNode next = top.next;
            tail.next = top;
            tail = tail.next;
            top.next = null;
            if (next != null) {
                heap.offer(next);
            }
        }

        return newHead.next;
    }
}
