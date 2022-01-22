package cn.zl.algo.week07.tree.exercise.type06;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表（中等）
 * @author: longzhang
 * @date: 2022/1/13
 */
public class Exercise03 {

    public static void main(String[] args) {
        Node node = new Node(1);
        Exercise03 e = new Exercise03();
        Node node1 = e.treeToDoublyList(node);
        System.out.println(node1);
    }


    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node head = null;
    Node tail = null;
    public Node treeToDoublyList(Node root) {
        inorder(root);
        // 大于等于1个节点时头尾串起来
        if (head != null) {
            tail.right = head;
            head.left = tail;
        }
        return head;
    }
    private void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        Node right = root.right;
        if (head == null) {
            head = root;
            tail = root;
            root.right = null;
        } else {
            tail.right = root;
            root.left = tail;
            tail = root;
            root.right = null;
        }
        inorder(right);
    }
}
