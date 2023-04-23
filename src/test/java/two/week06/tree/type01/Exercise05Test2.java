package two.week06.tree.type01;

import cn.zl.algo.week06.tree.common.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liusha
 * @date 2023/4/23
 */
public class Exercise05Test2 {

    private class StackNode {
        Node node;
        // 访问了几个子节点了
        int status;
        int childCnt;

        StackNode(Node node) {
            this.node = node;
            this.status = 0;
            this.childCnt = node.children == null ? 0 : node.children.size();
        }

    }

    public List<Integer> postorder(Node root) {
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
                res.add(cur.node.val);
                stack.pop();
            } else {
                Node child = cur.node.children.get(cur.status);
                cur.status++;
                stack.push(new StackNode(child));
            }
        }
        return res;
    }
}
