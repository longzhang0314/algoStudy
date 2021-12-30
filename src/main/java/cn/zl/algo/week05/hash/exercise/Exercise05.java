package cn.zl.algo.week05.hash.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 02.01 移除重复节点
 *
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 如果不得使用临时缓冲区，该怎么解决？
 *
 * @author: longzhang
 * @date: 2021/12/29
 */
public class Exercise05 {


    public static void main(String[] args) {
        Exercise05 e = new Exercise05();
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);
        h.next.next.next = new ListNode(3);
        h.next.next.next.next = new ListNode(2);
        h.next.next.next.next.next = new ListNode(1);
        ListNode listNode = e.removeDuplicateNodes2(h);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    // 方法1：哈希表
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prev = newHead;
        Set<Integer> set = new HashSet<>();
        while (prev.next != null) {
            if (!set.add(prev.next.val)) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return newHead.next;
    }

    // 方法2：O(1)空间
    // 1.新链表头，尾插，过滤重复元素，时间O(N^2)
    public ListNode removeDuplicateNodes2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(0);
        ListNode tail = newHead;
        ListNode p = head;
        while (p != null) {
            ListNode tmp = p.next;
            ListNode q = newHead;
            while (q.next != null && q.next.val != p.val) {
                q = q.next;
            }
            if (q.next == null) {
                tail.next = p;
                p.next = null;
                tail = tail.next;
            }
            p = tmp;
        }
        return newHead.next;
    }






















}
