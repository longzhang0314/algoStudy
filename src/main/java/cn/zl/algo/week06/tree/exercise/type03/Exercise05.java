package cn.zl.algo.week06.tree.exercise.type03;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * 226. 翻转二叉树
 *
 * 先翻转子树
 * @author: longzhang
 * @date: 2022/1/8
 */
public class Exercise05 {

    // 方法1：先翻转子树
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode newLeft = invertTree(root.left);
        TreeNode newRight = invertTree(root.right);
        root.left = newRight;
        root.right = newLeft;
        return root;
    }


    // 方法2：从上往下翻转
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        invertTree1(root.left);
        invertTree1(root.right);
        return root;
    }
}
