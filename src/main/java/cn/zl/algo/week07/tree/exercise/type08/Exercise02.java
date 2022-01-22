package cn.zl.algo.week07.tree.exercise.type08;

import cn.zl.algo.week06.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径（中等）
 * @author liusha
 * @date 2022/1/15
 */
public class Exercise02 {

    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, target, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode root, int target, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        dfs(root.left, target, list);
        dfs(root.right, target, list);
        list.remove(list.size() - 1);
    }

}
