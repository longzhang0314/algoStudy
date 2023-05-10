package two.week07.tree.type08;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * @author: longzhang
 * @date: 2023/5/10
 */
public class Exercise03Test2 {


    // 124
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        travel(root);
        return res;
    }

    // 该算法返回当前根节点 + 左/右单边的最大路径
    private int travel(TreeNode root) {
        if (root == null) return 0;
        int leftPath = Math.max(travel(root.left), 0);
        int rightPath = Math.max(travel(root.right), 0);
        res = Math.max(res, leftPath+ rightPath + root.val);

        return Math.max(leftPath, rightPath) + root.val;
    }
}
