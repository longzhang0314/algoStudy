package cn.zl.algo.week10.dp.common.pack.exercise.type03;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * @author liusha
 * @date 2022/3/16
 */
public class Exercise03Test {


    public int rob(TreeNode root) {
        int[] res = travel(root);
        return Math.max(res[0], res[1]);
    }

    private int[] travel(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = travel(root.left);
        int[] right = travel(root.right);

        int rob = left[0] + right[0] + root.val;
        int noRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{noRob, rob};
    }
}
