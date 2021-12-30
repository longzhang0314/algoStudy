package cn.zl.algo.week05.hash.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 160. 相交链表（简单）
 *
 * 仅练习哈希表，统计长度并快指针先走的方式在链表已练
 *
 * @author: longzhang
 * @date: 2021/12/29
 */
public class Exercise03 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        Set<ListNode> set = new HashSet<>();
        ListNode p =  headA;
        while (p != null) {
            set.add(p);
            p = p.next;
        }
        ListNode q = headB;
        while (q != null) {
            if (set.contains(q)) return q;
            q = q.next;
        }
        return null;
    }















}
