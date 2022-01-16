package cn.zl.algo.week07.tree.type05;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * 236. 二叉树的最近公共祖先（中等）
 *
 * TODO do 再练练
 * @author: longzhang
 * @date: 2022/1/13
 */
public class Exercise01 {

    // 左子树中有1个p或q,右子树中有一个p或q，那么当前节点是最小公共祖先
    // 当前节点和p或q相等，左子树有一个p或q 或者 右子树有一个p或q，当前节点是根节点
    // 问题转化为递归求以当前节点的树有几个p或q，通过子树的解找到祖先
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return lca;
    }

    private int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || lca != null) return 0;
        int leftCnt = dfs(root.left, p, q);
        if (lca != null) {
            return 2;
        }
        int rightCnt = dfs(root.right, p, q);
        if (lca != null) {
            return 2;
        }
        // 左右子树各有一个
        if (leftCnt == 1 && rightCnt == 1) {
            lca = root;
            return 2;
        }
        if ((root == p || root == q) && leftCnt + rightCnt == 1) {
            lca = root;
            return 2;
        }
        return leftCnt + rightCnt + (root == p || root == q ? 1 : 0);
    }
}
