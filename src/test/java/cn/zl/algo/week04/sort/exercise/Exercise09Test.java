package cn.zl.algo.week04.sort.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * @author: longzhang
 * @date: 2021/12/27
 */
public class Exercise09Test {


    public static void main(String[] args) {
        Exercise09Test e = new Exercise09Test();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode newHead = e.sortList(head);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        int n = len(head);
        int step = 1;
        while (step < n) {
            ListNode newHead = new ListNode(0);
            ListNode tail = newHead;
            ListNode p = head;
            while (p != null) {
                // find q
                ListNode q = p;
                int cnt = 1;
                while (q != null && cnt < step) {
                    q = q.next;
                    cnt++;
                }
                // [p,q] 1个
                if (q == null || q.next == null) {
                    tail.next = p;
                    break;
                }
                // find r r至少有一个
                ListNode p2 = q.next;
                ListNode r = q.next;
                q.next = null;
                cnt = 1;
                while (r != null && cnt < step) {
                    r = r.next;
                    cnt++;
                }
                ListNode tmp = r == null ? null : r.next;
                if (r != null) {
                    r.next = null;
                }
                //[q+1, r]
                ListNode[] headAndTail = mergeList(p, p2);
                tail.next = headAndTail[0];
                tail = headAndTail[1];
                p = tmp;
            }
            head = newHead.next;
            step *= 2;
        }
        return head;
    }

    private int len(ListNode head) {
        if (head == null) return 0;
        ListNode p = head;
        int cnt = 0;
        while (p != null) {
            cnt++;
            p = p.next;
        }
        return cnt;
    }


    private ListNode[] mergeList(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode tail = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                ListNode tmp = l1.next;
                tail.next = l1;
                l1.next = null;
                tail = tail.next;
                l1 = tmp;
            } else {
                ListNode tmp = l2.next;
                tail.next = l2;
                l2.next = null;
                tail = tail.next;
                l2 = tmp;
            }
        }

        while (l1 != null) {
            tail.next = l1;
            l1 = l1.next;
            tail = tail.next;
        }

        while (l2 != null) {
            tail.next = l2;
            l2 = l2.next;
            tail = tail.next;
        }

        return new ListNode[]{newHead.next, tail};
    }




    // 递归写法
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode min = findMin(head);
        ListNode next = min.next;
        min.next = null;
        ListNode l1 = sortList2(head);
        ListNode l2 = sortList2(next);
        return merge(l1, l2);
    }

    private ListNode findMin(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
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
                p = p.next;
                l1 = l1.next;
            } else {
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return newHead.next;
    }
}
