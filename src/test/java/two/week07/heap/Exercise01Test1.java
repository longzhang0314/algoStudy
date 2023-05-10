package two.week07.heap;

import cn.zl.algo.week02.linked.common.ListNode;

import java.util.PriorityQueue;

/**
 * @author: longzhang
 * @date: 2023/5/10
 */
public class Exercise01Test1 {

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
