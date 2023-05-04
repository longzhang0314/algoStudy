package two.week06.tree.type03;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * @author liusha
 * @date 2023/4/25
 */
public class Exercise03Test2 {

    boolean isBalance = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        preOrder(root);
        return isBalance;
    }

    private int preOrder(TreeNode root) {
        if (root == null) return 0;
        if (!isBalance) return 0;
        int leftDepth = preOrder(root.left);
        int rightDepth = preOrder(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            isBalance = false;
            return 0;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
