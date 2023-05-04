package two.week07.tree.type06;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * @author liusha
 * @date 2023/5/4
 */
public class Exercise01Test2 {

    TreeNode newHead = new TreeNode(0);
    TreeNode tail = newHead;
    public void flatten(TreeNode root) {
        if (root == null) return;
        tail.right = root;
        tail = root;
        TreeNode left = root.left;
        root.left = null;
        TreeNode right = root.right;
        flatten(left);
        flatten(right);
    }

}
