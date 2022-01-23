package cn.zl.algo.week07.tree.exercise.type08;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * 543. 二叉树的直径（简单）
 *
 * [注意]方法2复杂度更低的解法
 *
 * @author liusha
 * @date 2022/1/15
 */
public class Exercise01 {

    // 方法2：递归求树的深度，递归过程中更新全局最长直径
    int res = 0;
    public int diameterOfBinaryTree2(TreeNode root) {
        preorder(root);
        return res;
    }

    private int preorder(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = preorder(root.left);
        int rightDepth = preorder(root.right);
        res = Math.max(res, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }


    // 方法1：这种做法复杂度较高，容易理解，但不推荐
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int leftD = diameterOfBinaryTree(root.left);
        int rightD = diameterOfBinaryTree(root.right);
        return max(leftD, rightD, depth(root.left) + depth(root.right));
    }

    // 树的最大深度
    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    private int max(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }
}
