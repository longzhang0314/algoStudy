package cn.zl.algo.week06.tree.exercise.type03;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * 剑指 Offer 55 - II. 平衡二叉树（中等）
 *
 * TODO do 过两天再写一遍，关注递归模板思路
 *
 * @author: longzhang
 * @date: 2022/1/8
 */
public class Exercise03 {


    // 该问题不好直接由子问题转化：子树平衡不能直接推出根树平衡；
    // 问题转化为递归求每个节点的深度，求解过程中判断当前节点左右子树是否大于1，大于1当前节点就不平衡，剪枝返回
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        preorder(root);
        return isBalanced;
    }

    private int preorder(TreeNode root) {
        if (root == null) return 0;
        if (!isBalanced) return 0;
        int leftDepth = preorder(root.left);
        int rightDepth = preorder(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            isBalanced = false;
            return 0;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
