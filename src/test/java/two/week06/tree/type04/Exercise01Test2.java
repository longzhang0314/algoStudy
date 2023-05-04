package two.week06.tree.type04;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * @author liusha
 * @date 2023/5/4
 */
public class Exercise01Test2 {

    Integer res = null;
    int count = 0;
    public int kthLargest(TreeNode root, int k) {
        if (root == null || k <= 0) return res;
        inorder(root, k);
        return res == null ? -1 : res;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null || res != null) return;
        inorder(root.right, k);
        if (++count == k) {
            res = root.val;
            return;
        }
        inorder(root.left, k);
    }
}
