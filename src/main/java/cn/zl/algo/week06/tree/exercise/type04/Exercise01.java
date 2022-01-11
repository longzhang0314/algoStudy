package cn.zl.algo.week06.tree.exercise.type04;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点（中等）
 *
 * 剪枝
 *
 * @author: longzhang
 * @date: 2022/1/8
 */
public class Exercise01 {

    int count = 0;
    int res = -1;
    public int kthLargest(TreeNode root, int k) {
        postorder(root, k);
        return res;
    }

    private void postorder(TreeNode root, int k) {
        if (root == null) return;
        postorder(root.right, k);
        if (count >= k) return; // 剪枝
        count++;
        if (k == count) {
            res = root.val;
            return;
        }
        postorder(root.left, k);
    }
}
