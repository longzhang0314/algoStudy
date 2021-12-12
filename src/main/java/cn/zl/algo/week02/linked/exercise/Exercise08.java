package cn.zl.algo.week02.linked.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * 328. 奇偶链表（中等）
 * @author: longzhang
 * @date: 2021/12/8
 *
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 */
public class Exercise08 {

    /**
     * 输入: 1->2->3->4->5->NULL
     * 输出: 1->3->5->2->4->NULL
     * @param head
     * @return
     */
    // 方法1：单独构建奇数链表和偶数链表，空间O(1)插入
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode oddHead = new ListNode(0);
        ListNode odd = oddHead;
        ListNode evenHead = new ListNode(0);
        ListNode even = evenHead;
        ListNode p = head;

        int cnt = 0;
        while (p != null) {
            ++cnt;
            ListNode tmp = p.next;
            if ((cnt & 1) == 1) {
                odd.next = p;
                p.next = null;
                odd = odd.next;
            }  else {
                even.next = p;
                p.next = null;
                even = even.next;
            }
            p = tmp;
        }
        odd.next = evenHead.next;
        return oddHead.next;
    }

    // 方法2：原链表上倒腾
    public ListNode oddEvenList2(ListNode head) {
        // TODO 原链表上倒腾
        return null;
    }

}
