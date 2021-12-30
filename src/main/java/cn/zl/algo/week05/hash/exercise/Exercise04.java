package cn.zl.algo.week05.hash.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 141.环形链表（简单）
 *
 * @author: longzhang
 * @date: 2021/12/29
 */
public class Exercise04 {


    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (!set.add(p)) return true;
            p = p.next;
        }
        return false;


    }
}
