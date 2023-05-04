package two.week07.tree.type06;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * @author liusha
 * @date 2023/5/4
 */
public class Exercise02Test2 {

    TreeNode newHead = new TreeNode(0);
    TreeNode tail = newHead;
    public TreeNode convertBiNode(TreeNode root) {
        inorder(root);
        return newHead.right;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        tail.right = root;
        tail = root;
        root.left = null;
        inorder(root.right);
    }
}
