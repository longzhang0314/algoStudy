package cn.zl.algo.week07.tree.type05;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * @author liusha
 * @date 2022/1/22
 */
public class Exercise01Test {

    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return lca;
    }

    // 这课树有几个p或q
    private int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || lca != null) {
            return 0;
        }
        int leftCnt = dfs(root.left, p, q);
        if (lca != null) {
            return 2;
        }
        int rightCnt = dfs(root.right, p, q);
        if (lca != null) {
            return 2;
        }
        // 左右各一个；或者root和p或q相等，且左右加起来有1个
        if ((leftCnt == 1 && rightCnt == 1) || ((root == p || root == q) && leftCnt + rightCnt == 1)) {
            lca = root;
            return 2;
        }

        return leftCnt + rightCnt + (root == p || root == q ? 1 : 0);
    }
}
