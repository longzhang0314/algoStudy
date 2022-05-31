package two.week02;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * @author liusha
 * @date 2022/5/30
 */
public class Exercise07Test2 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        // 找到mid(偶数取前一个)，然后反转
        ListNode mid = findMid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        ListNode second = reverse(midNext);
        ListNode first = head;
        while (second != null) {
            // 对比。。
        }
        return false;
    }

    // 快慢指针
    private ListNode findMid(ListNode head) {
        return null;
    }

    private ListNode reverse(ListNode midNext) {
        return null;
    }
}
