package two.week10.exercise.type03;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * @author 流沙
 * @date 2024/3/4
 */
public class Exercise03Test2 {

    // 337
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] res = travel(root);
        return Math.max(res[0], res[1]);
    }

    // 0:当前选；1:当前不选
    private int[] travel(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = travel(root.left);
        int[] right = travel(root.right);
        int curSel = left[0] + right[0] + root.val;
        int curNoSel = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{curNoSel, curSel};
    }
}
