package cn.zl.algo.week06.tree.exercise.type03;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * 226. 翻转二叉树
 * @author: longzhang
 * @date: 2022/1/8
 */
public class Exercise05 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
