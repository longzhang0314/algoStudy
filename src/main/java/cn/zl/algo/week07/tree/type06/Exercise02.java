package cn.zl.algo.week07.tree.type06;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * 面试题 17.12. BiNode（中等）
 * @author: longzhang
 * @date: 2022/1/13
 */
public class Exercise02 {

    TreeNode newHead = new TreeNode(0);
    TreeNode tail = newHead;
    public TreeNode convertBiNode(TreeNode root) {
        inorder(root);
        return newHead.right;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        TreeNode left = root.left;
        TreeNode right = root.right;
        tail.right = root;;
        tail = root;
        root.left = null;
        root.right = null;
        inorder(right);
    }
}
