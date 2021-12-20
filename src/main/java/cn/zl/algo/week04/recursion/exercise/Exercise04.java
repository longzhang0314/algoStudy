package cn.zl.algo.week04.recursion.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指Offer 06 从尾到头打印链表（简单）
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * @author liusha
 * @date 2021/12/20
 */
public class Exercise04 {

    // 递归翻转
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        reverse(head, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void reverse(ListNode head, List<Integer> list) {
        if (head == null) return;
        ListNode p = head;
        reverse(p.next, list);
        list.add(p.val);
    }

}
