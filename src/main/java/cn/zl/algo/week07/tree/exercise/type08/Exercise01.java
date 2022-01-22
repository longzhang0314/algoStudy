package cn.zl.algo.week07.tree.exercise.type08;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * 543. 二叉树的直径（简单）
 * @author liusha
 * @date 2022/1/15
 */
public class Exercise01 {

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
