package cn.zl.algo.week06.tree.exercise.type04;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * 538. 把二叉搜索树转换为累加树（中等）
 *
 * @author: longzhang
 * @date: 2022/1/8
 */
public class Exercise02 {

    TreeNode prev = null;
    public TreeNode convertBST(TreeNode root) {
        postOrder(root);
        return root;
    }

    private void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.right);
        root.val += prev == null ? 0 : prev.val;
        prev = root;
        postOrder(root.left);
    }
}
