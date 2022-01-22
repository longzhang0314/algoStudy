package cn.zl.algo.week07.tree.exercise.type05;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先（中等）
 *
 * 递归、非递归实现
 * @author: longzhang
 * @date: 2022/1/13
 */
public class Exercise02 {

    // 递归解法
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

    // 非递归
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val > p.val && cur.val > q.val) {
                cur = cur.left;
            } else if (cur.val < p.val && cur.val < q.val) {
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return null;
    }
}
