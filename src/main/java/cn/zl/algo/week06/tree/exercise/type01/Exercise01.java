package cn.zl.algo.week06.tree.exercise.type01;

import cn.zl.algo.week06.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 题型1：二叉树前中后序遍历
 *
 * 144. 二叉树的前序遍历（简单）
 *
 * 迭代解法，要求能讲出来
 *
 * @author: longzhang
 * @date: 2022/1/8
 */
public class Exercise01 {



    // 方法3：迭代法：要求能讲出为什么这么写
    private class StackTreeNode {
        public TreeNode node;
        // 1: 访问到root，但没有访问子节点；2：访问完左子树回来了，没有访问右子树；3：左右子树都访问完了
        public int status;
        public StackTreeNode(TreeNode node) {
            this.node = node;
            this.status = 1;
        }
    }
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<StackTreeNode> stack = new Stack<>();
        stack.push(new StackTreeNode(root));

        while (!stack.isEmpty()) {
            StackTreeNode cur = stack.peek();
            if (cur.status == 1) {
                res.add(cur.node.val);
                cur.status = 2;
                if (cur.node.left != null) {
                    stack.push(new StackTreeNode(cur.node.left));
                }
            } else if (cur.status == 2) {
                cur.status = 3;
                if (cur.node.right != null) {
                    stack.push(new StackTreeNode(cur.node.right));
                }
            } else {
                stack.pop();
            }
        }

        return res;
    }


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
