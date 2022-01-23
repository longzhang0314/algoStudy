package cn.zl.algo.week07.heap.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

import java.util.PriorityQueue;

/**
 * @author: longzhang
 * @date: 2022/1/23
 */
public class Exercise01Test {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int k = lists.length;
        // 小顶堆，堆顶是最小的元素
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < k; i++) {
            if (lists[i] == null) continue;
            heap.offer(lists[i]);
        }

        ListNode newHead = new ListNode(0);
        ListNode tail = newHead;
        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            ListNode next = cur.next;
            tail.next = cur;
            tail = tail.next;
            cur.next = null;
            if (next != null) {
                heap.offer(next);
            }
        }
        return newHead.next;
    }
}
