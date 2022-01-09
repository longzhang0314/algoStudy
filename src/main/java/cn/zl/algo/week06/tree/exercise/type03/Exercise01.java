package cn.zl.algo.week06.tree.exercise.type03;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * 题型3：二叉树上的递归
 *
 * 104. 二叉树的最大深度（简单）
 *
 * @author: longzhang
 * @date: 2022/1/8
 */
public class Exercise01 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
