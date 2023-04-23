package two.week06.tree.type01;

import cn.zl.algo.week06.tree.common.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

/**
 * @author liusha
 * @date 2023/4/23
 */
public class Exercise04Test2 {


    public List<Integer> preorder(Node root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        if (root.children != null) {
            for (Node child : root.children) {
                res.addAll(preorder(child));
            }
        }
        return res;
    }

    private void preorder(Node root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        if (root.children != null) {
            for (Node child : root.children) {
                preorder(child, res);
            }
        }
    }


    private class StackNode {
        Node node;
        // 已访问完几个子节点
        int status;
        int childCnt;

        StackNode(Node node) {
            this.node = node;
            this.status = 0;
            this.childCnt = node.children == null ? 0 : node.children.size();
        }
    }

    public List<Integer> preorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<StackNode> stack = new Stack<>();
        stack.push(new StackNode(root));
        while (!stack.isEmpty()) {
            StackNode cur = stack.peek();
            if (cur.childCnt == 0) {
                res.add(cur.node.val);
                stack.pop();
                continue;
            }
            if (cur.status == cur.childCnt) {
                stack.pop();
            } else {
                if (cur.status == 0) {
                    res.add(cur.node.val);
                }
                Node child = cur.node.children.get(cur.status);
                stack.push(new StackNode(child));
                cur.status++;
            }
        }
        return res;
    }
}
