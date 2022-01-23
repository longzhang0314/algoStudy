package cn.zl.algo.week07.tree.exercise.type08;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * @author: longzhang
 * @date: 2022/1/23
 */
public class Exercise03Test {

    // 最大路径和
    // 递归求单边最大路径和，即root加左半边或者右半边，递归过程中更新全局最大路径和
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        max = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
