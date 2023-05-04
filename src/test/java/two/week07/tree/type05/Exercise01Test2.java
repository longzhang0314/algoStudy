package two.week07.tree.type05;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * @author liusha
 * @date 2023/5/4
 */
public class Exercise01Test2 {


    // 1. left 1cnt, right 1cnt, return root
    // 2. root==p | root==q, and left 1cnt or right 1cnt, return root
    // so, the question convert dfs calculate current node has p and q count
    TreeNode res = null;
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null) return q;
        if (q == null) return p;
        // postOrder，if res != null, find it
        postOrder(root, p, q);
        return res;
    }

    private int postOrder(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || res != null) return 0;
        int leftCnt = postOrder(root.left, p, q);
        int rightCnt = postOrder(root.right, p, q);
        if (leftCnt == 1 && rightCnt == 1) {
            res = root;
            return 2;
        }
        if ((root == p || root == q) && leftCnt + rightCnt == 1) {
            res = root;
            return 2;
        }
        return leftCnt + rightCnt + ((root == p || root == q) ? 1 : 0);
    }



    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        return left == null ? right : right == null ? left : root;
    }
}
