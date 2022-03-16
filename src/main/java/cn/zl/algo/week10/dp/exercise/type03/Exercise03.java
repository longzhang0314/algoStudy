package cn.zl.algo.week10.dp.exercise.type03;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * 337. 打家劫舍3
 *
 * 后续遍历+打家劫舍
 *
 * @author liusha
 * @date 2022/2/24
 */
public class Exercise03 {



    public int ro2(TreeNode root) {
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

    //  ------------



    public int rob(TreeNode root) {
        // dfs，记录上一层偷/不偷的最大路径，推导当前层偷/不偷的最大路径
        int[] dfs = dfs(root);
        return Math.max(dfs[0], dfs[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int curRob = root.val;
        int curNot = 0;
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        if (left != null) {
            curRob = curRob + left[0];
            curNot = curNot + Math.max(left[0], left[1]);
        }
        if (right != null) {
            curRob = curRob + right[0];
            curNot = curNot + Math.max(right[0], right[1]);
        }
        return new int[]{curNot, curRob};
    }
}
