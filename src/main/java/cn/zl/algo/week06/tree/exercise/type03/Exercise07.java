package cn.zl.algo.week06.tree.exercise.type03;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * 98. 验证二叉搜索树（中等）
 *
 * TODO 方法2：递归实现，过两天再写一遍，关注递归模板思路
 *
 * @author: longzhang
 * @date: 2022/1/8
 */
public class Exercise07 {


    // 方法2：递归的思路，需要重点关注这种解法
    boolean isBST = true;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        check(root);
        return isBST;
    }

    // 验证是否是二叉搜索树，返回左子树最大值和右子树最小值
    private int[] check(TreeNode root) {
        if (!isBST) return null;
        int min = root.val;
        int max = root.val;
        if (root.left != null) {
            // 0最小值，1最大值
            int[] leftSub = check(root.left);
            if (!isBST) return null;
            if (leftSub != null) {
                if (leftSub[1] >= root.val) {
                    isBST = false;
                    return null;
                }
                min = leftSub[0];
            }
        }

        if (root.right != null) {
            int[] rightSub = check(root.right);
            if (rightSub != null) {
                if (rightSub[0] <= root.val) {
                    isBST = false;
                    return null;
                }
                max = rightSub[1];
            }
        }
        return new int[]{min, max};
    }


    // 方法1：中序遍历，和前一个元素比较
    boolean flag = true;
    TreeNode prev = null;
    public boolean isValidBST1(TreeNode root) {
        if (root == null) return true;
        inorder(root);
        return flag;
    }

    private void inorder(TreeNode root) {
        if (root == null || !flag) return;
        inorder(root.left);
        if (prev != null) {
            if (root.val <= prev.val) {
                flag = false;
                return;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
