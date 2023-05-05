package two.week07.tree.type06;


/**
 * @author liusha
 * @date 2023/5/5
 */
public class Exercise03Test2 {

    class Node {
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
        if (head != null) {
            tail.right = head;
            head.left = tail;
        }
        return head;
    }

    private void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        if (head == null) {
            head = root;
            tail = root;
        } else {
            tail.right = root;
            root.left = tail;
            tail = tail.right;
        }
        inorder(root.right);
    }
}
