package cn.zl.algo.week06.tree.exercise.type01;

import cn.zl.algo.week06.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历（简单）
 *
 * 迭代解法
 * @author: longzhang
 * @date: 2022/1/8
 */
public class Exercise03 {



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
                res.add(cur.node.val);
                stack.pop();
            }
        }

        return res;
    }



    // 方法1
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(res, root);
        return res;
    }

    private void postorder(List<Integer> res, TreeNode root) {
        if (root == null) return;
        postorder(res, root.left);
        postorder(res, root.right);
        res.add(root.val);
    }

    // 方法2
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        res.addAll(postorderTraversal(root.left));
        res.addAll(postorderTraversal(root.right));
        res.add(root.val);
        return res;
    }
}
