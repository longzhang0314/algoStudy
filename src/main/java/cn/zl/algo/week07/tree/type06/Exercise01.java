package cn.zl.algo.week07.tree.type06;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * 114. 二叉树展开为链表（中等）
 * @author: longzhang
 * @date: 2022/1/13
 */
public class Exercise01 {

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
        tail = root;
        root.left = null;
        preorder(left);
        preorder(right);
    }
}
