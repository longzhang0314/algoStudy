package cn.zl.algo.week07.tree.type05;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先（中等）
 * @author: longzhang
 * @date: 2022/1/13
 */
public class Exercise02 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) return root;
        // p小 q大，统一处理
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val >= p.val && cur.val <= q.val) {
                return cur;
            } else if (cur.val < p.val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return null;
    }
}
