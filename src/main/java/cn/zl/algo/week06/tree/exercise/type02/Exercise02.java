package cn.zl.algo.week06.tree.exercise.type02;

import cn.zl.algo.week06.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历（中等）
 *
 * BFS三种方法：size，存层号（再写下这种解法），存null（再写下这种解法）
 *
 * @author: longzhang
 * @date: 2022/1/8
 */
public class Exercise02 {


    private class MyTreeNode {
        public TreeNode node;
        public int level;
        public MyTreeNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    // 方法4：存行号作为分行的依据
    public List<List<Integer>> levelOrder4(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<MyTreeNode> queue = new LinkedList<>();
        queue.offer(new MyTreeNode(root, 0));
        while (!queue.isEmpty()) {
            MyTreeNode cur = queue.poll();
            if (res.size() == cur.level) {
                res.add(new ArrayList<>());
            }
            res.get(cur.level).add(cur.node.val);
            if (cur.node.left != null) queue.offer(new MyTreeNode(cur.node.left, cur.level + 1));
            if (cur.node.right != null) queue.offer(new MyTreeNode(cur.node.right, cur.level + 1));
        }
        return res;
    }


    // 方法3：BFS，存null作为层与层之间间隔
    public List<List<Integer>> levelOrder3(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (true) {
                TreeNode cur = queue.poll();
                if (cur == null) break;
                list.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            res.add(list);
            if (!queue.isEmpty()) {
                queue.offer(null);
            }
        }
        return res;
    }


    // 方法1：BFS：size
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curList = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                curList.add(curNode.val);
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
            }
            res.add(curList);
        }

        return res;
    }


    // 方法2：DFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrder(res, root, 0);
        return res;
    }

    private void levelOrder(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) return;
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        List<Integer> curList = res.get(level);
        curList.add(root.val);
        levelOrder(res, root.left, level + 1);
        levelOrder(res, root.right, level + 1);
    }
}
