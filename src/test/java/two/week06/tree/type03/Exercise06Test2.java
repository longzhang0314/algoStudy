package two.week06.tree.type03;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * @author liusha
 * @date 2023/4/26
 */
public class Exercise06Test2 {


    // 轴对称
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val
                && isSymmetric(left.left, right.right)
                && isSymmetric(left.right, right.left);
    }
}
