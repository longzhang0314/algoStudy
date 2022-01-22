package cn.zl.algo.week07.tree.type06;

import cn.zl.algo.week02.linked.common.ListNode;
import cn.zl.algo.week06.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liusha
 * @date 2022/1/22
 */
public class Exercise04Test {

    private class MyNode {
        public TreeNode root;
        public int level;

        public MyNode(TreeNode root, int level) {
            this.root = root;
            this.level = level;
        }
    }

    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) return new ListNode[0];
        List<ListNode> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        queue.offer(null);

        while (!queue.isEmpty()) {
            ListNode newHead = new ListNode(0);
            ListNode tail = newHead;
            while (true) {
                TreeNode cur = queue.poll();
                if (cur == null) break;
                tail.next = new ListNode(cur.val);
                tail = tail.next;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            list.add(newHead.next);
            if (!queue.isEmpty()) {
                queue.offer(null);
            }
        }

        ListNode[] res = new ListNode[list.size()];
        int i = 0;
        for (ListNode node : list) {
            res[i++] = node;
        }
        return res;
    }
}
