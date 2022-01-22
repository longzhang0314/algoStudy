package cn.zl.algo.week07.tree.type06;

import cn.zl.algo.week02.linked.common.ListNode;
import cn.zl.algo.week06.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 面试题 04.03. 特定深度节点链表（中等）
 *
 * 【BFS】也可
 * 【扩展】用right指针连接
 * @author: longzhang
 * @date: 2022/1/13
 */
public class Exercise04 {

    private class NodeObj {
        public ListNode head;
        public ListNode tail;

        public NodeObj() {
            this.head = new ListNode(0);
            this.tail = head;
        }
    }

    public ListNode[] listOfDepth(TreeNode tree) {
        List<NodeObj> list = new ArrayList<>();
        dfs(tree, list, 0);
        ListNode[] res = new ListNode[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i).head.next;
        }
        return res;
    }

    private void dfs(TreeNode root, List<NodeObj> list, int level) {
        if (root == null) return;
        if (list.size() == level) {
            list.add(new NodeObj());
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        ListNode tail = list.get(level).tail;
        tail.next = new ListNode(root.val);
        // 这里不能直接用tail=tail.next，因为这里的tail是在这个栈里面取出来的引用地址
        list.get(level).tail = tail.next;
        dfs(left, list, level + 1);
        dfs(right, list, level + 1);
    }


    // ===================== BFS

    // BFS
    public ListNode[] listOfDepth1(TreeNode tree) {
        if (tree == null) return new ListNode[0];
        List<ListNode> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        queue.offer(null);

        // 用null分层的方式写
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
