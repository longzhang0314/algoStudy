package cn.zl.algo.week06.tree.exercise.type03;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * 98. 验证二叉搜索树（中等
 *
 * @author: longzhang
 * @date: 2022/1/8
 */
public class Exercise07 {

    // 方法1：中序遍历，和前一个元素比较
    boolean flag = true;
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        inorder(root);
        return flag;
    }

    private void inorder(TreeNode root) {
        if (root == null || !flag) return;
        inorder(root.left);
        if (prev != null) {
            if (root.val <= prev.val) {
                flag = false;
                return;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
