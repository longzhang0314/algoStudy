package cn.zl.algo.week06.tree.exercise.type02;

import cn.zl.algo.week06.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III（中等）
 *
 *
 * @author: longzhang
 * @date: 2022/1/8
 */
public class Exercise03 {

    // 方法1：BFS，放的时候都是从左往右放，取的时候按层反转
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> curList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if ((level % 2) == 0) {
                    curList.add(curNode.val);
                } else {
                    curList.addFirst(curNode.val);
                }
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
            }
            res.add(curList);
            level++;
        }
        return res;
    }
}
