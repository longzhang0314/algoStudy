package two.week07.tree.type08;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * @author liusha
 * @date 2023/5/8
 */
public class Exercise01Test2 {

    // 问题转化为：递归求每个节点的最大深度，递归过程中得到最大直径
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        travel(root);
        return res;
    }

    private int travel(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = travel(root.left);
        int rightDepth = travel(root.right);
        res = Math.max(res, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
