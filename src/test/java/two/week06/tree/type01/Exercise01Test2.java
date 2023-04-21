package two.week06.tree.type01;

import cn.zl.algo.week06.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liusha
 * @date 2023/4/21
 */
public class Exercise01Test2 {

    // pre order:recursion and iteration
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }
    private void preorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }



    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        res.addAll(preorderTraversal2(root.left));
        res.addAll(preorderTraversal2(root.right));
        return res;
    }

    // iteration method
    public List<Integer> preorderTraversal3(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<StackNode> stack = new Stack<>();
        stack.push(new StackNode(root));

        while (!stack.isEmpty()) {
            StackNode rootNode = stack.peek();
            if (rootNode.status == 1) {
                res.add(rootNode.node.val);
                rootNode.status = 2;
                if (rootNode.node.left != null) {
                    stack.push(new StackNode(rootNode.node.left));
                }
            } else if (rootNode.status == 2) {
                rootNode.status = 3;
                if (rootNode.node.right != null) {
                    stack.push(new StackNode(rootNode.node.right));
                }
            } else {
                stack.pop();
            }
        }
        return res;
    }

    private class StackNode {
        TreeNode node;
        // 1.访问到root，但没有访问子节点；2.访问完左子树，还没访问右字数；3.访问完右子树，还没访问左子树
        int status;

        StackNode(TreeNode node) {
            this.node = node;
            this.status = 1;
        }
    }


}
