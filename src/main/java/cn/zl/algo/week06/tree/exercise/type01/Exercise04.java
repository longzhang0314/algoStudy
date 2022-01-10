package cn.zl.algo.week06.tree.exercise.type01;

import cn.zl.algo.week06.tree.common.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 589. N 叉树的前序遍历（简单）
 *
 * 【注意】迭代解法
 * @author: longzhang
 * @date: 2022/1/8
 */
public class Exercise04 {


    private class MyNode {
        public Node node;

        // 0：当前元素已访问，即将访问第0个child；
        // childCnt：所有child都已访问
        public int status;

        public int childCnt;
        public MyNode(Node node, int childCnt) {
            this.node = node;
            this.status = 0;
            this.childCnt = childCnt;
        }
    }

    // 方法3：迭代解法
    public List<Integer> preorder3(Node root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<MyNode> stack = new Stack<>();
        stack.push(new MyNode(root, root.children == null ? 0 : root.children.size()));

        while (!stack.isEmpty()) {
            MyNode peek = stack.peek();
            // 没有子节点
            if (peek.childCnt == 0) {
                res.add(peek.node.val);
                stack.pop();
                continue;
            }
            // 所有子节点都已访问
            if (peek.status == peek.childCnt) {
                stack.pop();
            } else {
                if (peek.status == 0) {
                    res.add(peek.node.val);
                }
                Node curChild = peek.node.children.get(peek.status);
                peek.status++;
                stack.push(new MyNode(curChild, curChild.children == null ? 0 : curChild.children.size()));
            }
        }
        return res;
    }


    // 方法1
    public List<Integer> preorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        pre(res, root);
        return res;
    }

    private void pre(List<Integer> res, Node root) {
        if (root == null) return;
        res.add(root.val);
        for (Node child : root.children) {
            pre(res, child);
        }
    }

    // 方法2
    public List<Integer> preorder(Node root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        for (Node child : root.children) {
            res.addAll(preorder(child));
        }
        return res;
    }
}
