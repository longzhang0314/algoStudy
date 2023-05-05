package two.week07.tree.type06;

import cn.zl.algo.week02.linked.common.ListNode;
import cn.zl.algo.week06.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liusha
 * @date 2023/5/5
 */
public class Exercise04Test2 {

    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> res = new ArrayList<>();
        travel(tree, 0, res);
        ListNode[] arr = new ListNode[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    private void travel(TreeNode tree, int level, List<ListNode> res) {
        if (tree == null) return;
        ListNode cur = new ListNode(tree.val);
        if (level >= res.size()) {
            res.add(cur);
        } else {
            ListNode head = res.get(level);
            while (head.next != null) {
                head = head.next;
            }
            head.next = cur;
        }

        travel(tree.left, level + 1, res);
        travel(tree.right, level + 1, res);
    }
}
