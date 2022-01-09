package cn.zl.algo.week06.tree.exercise.type01;

import cn.zl.algo.week06.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题型1：二叉树前中后序遍历
 *
 * 144. 二叉树的前序遍历（简单）
 *
 * TODO 迭代解法
 *
 * @author: longzhang
 * @date: 2022/1/8
 */
public class Exercise01 {


    // 方法1：时间O(N)，空间O(logN)
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(res, root);
        return res;
    }

    private void preorder(List<Integer> res, TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        preorder(res, root.left);
        preorder(res, root.right);
    }


    // 方法2：时间：大于O(N)的，具体不好分析，addAll导致；空间O(logN)
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;
    }




}
