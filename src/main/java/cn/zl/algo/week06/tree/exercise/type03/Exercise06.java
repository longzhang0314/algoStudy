package cn.zl.algo.week06.tree.exercise.type03;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * 101. 对称二叉树（中等）
 *
 * 【注意】递归的思考思路
 *
 * @author: longzhang
 * @date: 2022/1/8
 */
public class Exercise06 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        // 问题转化为考察左右子树是否是对称的
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        // 左子树的左子树 和 右子树的右子树 比较看是否对称；左子树的右子树 和 右子树的左子树 比较看是否对称；根节点是否相等
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
