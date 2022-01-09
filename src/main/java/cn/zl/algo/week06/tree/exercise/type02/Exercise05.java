package cn.zl.algo.week06.tree.exercise.type02;

import cn.zl.algo.week06.tree.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. 找树左下角的值（中等）
 *
 * 每层从右往左遍历，最后一个节点（BFS写法）
 * @author: longzhang
 * @date: 2022/1/8
 */
public class Exercise05 {

    // 方法1：BFS
    public int findBottomLeftValue1(TreeNode root) {
        if (root == null) return -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int curLeftVal = -1;
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (i == 0) curLeftVal = curNode.val;

                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
            }
            if (queue.isEmpty()) return curLeftVal;
        }
        return -1;
    }


    // 方法2：DFS
    int maxLevel = -1;
    int leftVal = -1;
    public int findBottomLeftValue(TreeNode root) {
        preorder(root, 0);
        return leftVal;
    }

    private void preorder(TreeNode root, int level) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (level > maxLevel) {
                maxLevel = level;
                leftVal = root.val;
            }
            return;
        }
        preorder(root.left, level + 1);
        preorder(root.right, level + 1);
    }

}
