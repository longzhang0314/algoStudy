package cn.zl.algo.week07.tree.type06;

/**
 * @author liusha
 * @date 2022/1/22
 */
public class Exercise03Test {

    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }


    Node pre = null;
    Node tail = null;
    public Node treeToDoublyList(Node root) {
        preorder(root);
        if (pre != null) {
            tail.right = pre;
            pre.left = tail;
        }
        return pre;
    }

    private void preorder(Node root) {
        if (root == null) return;
        preorder(root.left);
        Node right = root.right;
        if (pre == null) {
            pre = root;
            tail = root;
            pre.right = tail;
            tail.left = pre;
        } else {
            tail.right = root;
            root.left = tail;
            tail = root;
        }
        preorder(right);
    }
}
