package cn.zl.algo.week06.tree.exercise.type04;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * 538. 把二叉搜索树转换为累加树（中等）
 *
 * 记录sum即可
 *
 * @author: longzhang
 * @date: 2022/1/8
 */
public class Exercise02 {

    // 方法1：变量记录
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        postOrder(root);
        return root;
    }

    private void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.right);
        root.val += sum;
        sum = root.val;
        postOrder(root.left);
    }


    // 方法2：父节点记录
    TreeNode prev = null;
    public TreeNode convertBST1(TreeNode root) {
        postOrder1(root);
        return root;
    }

    private void postOrder1(TreeNode root) {
        if (root == null) return;
        postOrder1(root.right);
        root.val += prev == null ? 0 : prev.val;
        prev = root;
        postOrder1(root.left);
    }
}
