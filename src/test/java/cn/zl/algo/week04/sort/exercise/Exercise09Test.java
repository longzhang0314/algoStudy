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
        ListNode newHead = e.sortList4(head);

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
                int cnt = 1;
                // [p,q]
                ListNode q = p;
                while (q != null && cnt < step) {
                    q = q.next;
                    cnt++;
                }
                if (q == null || q.next == null) {
                    tail.next = p;
                    break;
                }
                // [p2, q2]
                ListNode p2 = q.next;
                q.next = null;
                ListNode q2 = p2;
                cnt = 1;
                while (q2 != null && cnt < step) {
                    q2 = q2.next;
                    cnt++;
                }
                ListNode tmp = q2 == null ? null : q2.next;
                if (q2 != null) {
                    q2.next = null;
                }

                // merge [p,q] [p2,q2]
                ListNode[] headAndTail = merge(p, p2);
                tail.next = headAndTail[0];
                tail = headAndTail[1];
                p = tmp;
            }
            head = newHead.next;
            step *= 2;
        }
        return head;
    }

    // l1,l2 not null
    private ListNode[] merge(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode tail = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        while (l1 != null) {
            tail.next = l1;
            tail = tail.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            tail.next = l2;
            tail = tail.next;
            l2 = l2.next;
        }
        return new ListNode[]{newHead.next, tail};
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

    // 冒泡
    public ListNode sortList3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        boolean flag = true;
        while (flag) {
            ListNode p = newHead;
            int cnt = 0;
            while (p.next != null && p.next.next != null) {
                if (p.next.val > p.next.next.val) {
                    cnt++;
                    ListNode tmp = p.next;

                    ListNode pNN = p.next.next;
                    p.next.next = p.next.next.next;
                    pNN.next = p.next;
                    p.next = pNN;

                    p = tmp;
                } else {
                    p = p.next;
                }
            }
            if (cnt == 0) flag = false;
        }
        return newHead.next;
    }


    public ListNode sortList4(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        int n = len(head);
        int cnt = 0;
        while (cnt < n) {
            ListNode p = newHead;
            // 先走cnt步
            int i = cnt;
            while (i > 0 && p.next != null) {
                i--;
                p = p.next;
            }
            // 从p.next开始，找到的最小元素放到p的后面
            ListNode q = p;
            ListNode prev = q;
            ListNode min = q.next;
            while (q.next != null) {
                if (q.next.val < min.val) {
                    prev = q;
                    min = q.next;
                }
                q = q.next;
            }
            prev.next = prev.next.next;
            min.next = p.next;
            p.next = min;

            cnt++;
        }
        return newHead.next;
    }


    public ListNode sortList5(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(0);
        ListNode p = head;
        while (p != null) {
            ListNode tmp = p.next;

            ListNode q = newHead;
            while (q.next != null && q.next.val < p.val) {
                q = q.next;
            }
            p.next = q.next;
            q.next = p;

            p = tmp;
        }
        return newHead.next;
    }

}
