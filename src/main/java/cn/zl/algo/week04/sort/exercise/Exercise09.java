package cn.zl.algo.week04.sort.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

/**
 * 148. 排序链表（中等）
 *
 * 链表上的插入、选择排序都写一下
 *
 * 【注意】方法3，非递归解法，因为要空间O(1)
 * 【注意】归并、冒泡、插入、选择
 *
 * @author liusha
 * @date 2021/12/21
 */
public class Exercise09 {


    // 方法1：归并 O(N^logN)
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == tail) return head;
        ListNode min = getMin(head, tail);
        ListNode minNext = min.next;
        min.next = null;
        ListNode l1 = sortList(head, min);
        ListNode l2 = sortList(minNext, tail);
        return merge(l1, l2);
    }

    private ListNode getMin(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail && fast.next.next != tail) {
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
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;

        return newHead.next;
    }

    // ========================================== 方法2 插入 =================================================


    // 方法2：插入排序 O(N^2) 不建议
    public ListNode sortList2(ListNode head) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0);
        ListNode tail = newHead;
        ListNode p = head;
        int cnt = 0;
        while (p != null) {
            cnt++;
            ListNode tmp = p.next;
            if (cnt == 1 || tail.val <= p.val) {
                tail.next = p;
                tail = tail.next;
                p.next = null;
                p = tmp;
                continue;
            }

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


    // ==================================================== 方法3 非递归归并==============================================


    // 方法3：非递归归并，空间O(1)
    public ListNode sortList3(ListNode head) {
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

    // ============================================= 方法4 冒泡 ==================================================


    // 冒泡
    public ListNode sortList4(ListNode head) {
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


    // ============================================= 方法5 选择 ==================================================

    public ListNode sortList5(ListNode head) {
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


}
