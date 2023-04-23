package two.week06.tree.type01;

import cn.zl.algo.week06.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liusha
 * @date 2023/4/23
 */
public class Exercise02Test2 {

    // inorder：left mid right
    public List<Integer> inorderTraversal(TreeNode root) {
        // 1.访问完left回来后再放入root
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<StackNode> stack = new Stack<>();
        stack.push(new StackNode(root));

        while (!stack.isEmpty()) {
            StackNode cur = stack.peek();
            if (cur.status == 1) {
                cur.status = 2;
                if (cur.node.left != null) {
                    stack.push(new StackNode(cur.node.left));
                }
            } else if (cur.status == 2) {
                cur.status = 3;
                res.add(cur.node.val);
                if (cur.node.right != null) {
                    stack.push(new StackNode(cur.node.right));
                }
            } else {
                stack.pop();
            }
        }
        return res;
    }

    private class StackNode {
        TreeNode node;
        // 1:only self; 2:already see left; 3.see right
        int status;

        public StackNode(TreeNode node) {
            this.node = node;
            this.status = 1;
        }
    }

}
