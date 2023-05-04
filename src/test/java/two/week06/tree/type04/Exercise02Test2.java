package two.week06.tree.type04;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * @author liusha
 * @date 2023/5/4
 */
public class Exercise02Test2 {

    // 变量控制
    int sum = 0;
    public TreeNode convertBST1(TreeNode root) {
        travel1(root);
        return root;
    }
    private void travel1(TreeNode root) {
        if (root == null) return;
        travel1(root.right);
        int tmp = sum;
        sum += root.val;
        root.val += tmp;
        travel1(root.left);
    }

    // 父节点控制
    TreeNode prev = null;
    public TreeNode convertBST(TreeNode root) {
        travel(root);
        return root;
    }
    private void travel(TreeNode root) {
        if (root == null) return;
        root.val += prev == null ? 0 : prev.val;
        prev = root;
        travel(root.left);
    }
}
