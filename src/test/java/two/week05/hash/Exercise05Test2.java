package two.week05.hash;

import cn.zl.algo.week02.linked.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liusha
 * @date 2023/4/11
 */
public class Exercise05Test2 {


    // method1:hash
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return null;
        ListNode pre = null, cur = head;
        Set<Integer> set = new HashSet<>();
        while (cur != null) {
            if (set.contains(cur.val)) {
                pre.next = pre.next.next;
                cur = pre.next;
                continue;
            }
            set.add(cur.val);
            pre = cur;
            cur = cur.next;
        }
        return head;
    }

    // method2:tail insert
    public ListNode removeDuplicateNodes2(ListNode head) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0);
        ListNode cur = head;
        while (cur != null) {
            ListNode q = newHead;
            ListNode next = cur.next;
            cur.next = null;
            while (q.next != null && q.next.val != cur.val) {
                q = q.next;
            }
            if (q.next == null) {
                q.next = cur;
            }
            cur = next;
        }
        return newHead.next;
    }
}
