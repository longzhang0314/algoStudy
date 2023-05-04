package two.week06.tree.type04;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * @author liusha
 * @date 2023/5/4
 */
public class Exercise03Test2 {

    TreeNode prev = null;
    TreeNode res = null;
    boolean find = false;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        travel(root, p);
        return res;
    }

    // inorder: right mid left
    private void travel(TreeNode root, TreeNode p) {
        if (root == null || find) return;
        travel(root.right, p);
        // find it
        if (p == root) {
            res = prev;
            prev = root;
            find = true;
            return;
        }
        prev = root;
        travel(root.left, p);
    }
}
