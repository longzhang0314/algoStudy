package cn.zl.algo.week07.tree.exercise.type08;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * 124. 二叉树中的最大路径和 （困难）
 *
 * [注意]经典思路
 * @author liusha
 * @date 2022/1/15
 */
public class Exercise03 {

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSingle(root);
        return max;
    }

    // 以root为根节点，单边的最大路径和（单边表示root走左子树路径或右子树路径，只走一边）
    // 在递归的过程中更新全局最长路径
    private int maxSingle(TreeNode root) {
        if (root == null) return 0;
        // 左边可以要，也可以不要
        int leftSingle = Math.max(maxSingle(root.left), 0);
        // 右边可以要，也可以不要
        int rightSingle = Math.max(maxSingle(root.right), 0);
        max = Math.max(leftSingle + rightSingle + root.val, max);
        return Math.max(leftSingle, rightSingle) + root.val;
    }
}
