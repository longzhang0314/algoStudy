package cn.zl.algo.week07.tree.exercise.type06;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * 展开，用right连接
 * @author liusha
 * @date 2022/1/22
 */
public class Exercise01Test {

    TreeNode newHead = new TreeNode(0);
    TreeNode tail = newHead;
    public void flatten(TreeNode root) {
        preorder(root);
    }

    private void preorder(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        tail.right = root;
        tail = tail.right;
        tail.left = null;
        tail.right = null;
        preorder(left);
        preorder(right);
    }
}
