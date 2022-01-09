package cn.zl.algo.week06.tree.exercise.type02;

import cn.zl.algo.week06.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历（中等）
 *
 * @author: longzhang
 * @date: 2022/1/8
 */
public class Exercise02 {


    // 方法1：BFS
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
