package cn.zl.algo.week06.tree.exercise.type03;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * @author: longzhang
 * @date: 2022/1/23
 */
public class Exercise03Test {

    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return isBalanced;
    }

    // 递归求树的深度，过程中全局变量赋值
    private int dfs(TreeNode root) {
        if (root == null || !isBalanced) {
            return 0;
        }
        int left = dfs(root.left);
        if (!isBalanced) {
            return 0;
        }
        int right = dfs(root.right);
        if (!isBalanced) {
            return 0;
        }
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
            return 0;
        }
        return Math.max(left, right) + 1;
    }
}
