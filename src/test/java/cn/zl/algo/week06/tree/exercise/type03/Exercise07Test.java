package cn.zl.algo.week06.tree.exercise.type03;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * @author: longzhang
 * @date: 2022/1/23
 */
public class Exercise07Test {

    boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return isValid;
    }

    // 递归求当前这棵树的最大值和最小值
    // 如果左子树的最大值大于根节点，或者右子树的最小值小于根节点，全局赋值false
    private int[] dfs(TreeNode root) {
        if (root == null || !isValid) {
            return null;
        }
        int min = root.val;
        int max = root.val;
        if (root.left != null) {
            int[] leftSub = dfs(root.left);
            if (!isValid) return null;
            if (leftSub != null) {
                if (leftSub[1] >= root.val) {
                    isValid = false;
                    return null;
                }
                min = leftSub[0];
            }
        }

        if (root.right != null) {
            int[] rightSub = dfs(root.right);
            if (!isValid) return null;
            if (rightSub != null) {
                if (rightSub[0] <= root.val) {
                    isValid = false;
                    return null;
                }
                max = rightSub[1];
            }
        }
        return new int[]{min, max};
    }
}
