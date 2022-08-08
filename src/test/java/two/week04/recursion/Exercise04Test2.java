package two.week04.recursion;

import cn.zl.algo.week02.linked.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liusha
 * @date 2022/7/27
 */
public class Exercise04Test2 {

    // TODO 待测
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];
        List<Integer> list = reversePrint1(head);
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private List<Integer> reversePrint1(ListNode head) {
        if (head == null) return new ArrayList<>();
        List<Integer> sub = reversePrint1(head.next);
        sub.add(head.val);
        return sub;
    }
}
