package cn.zl.algo.week08.backtrack.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 39.组合总和（中等）
 *
 * //给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的
 * // 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * //
 * // candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * //输入：candidates = [2,3,6,7], target = 7
 * //输出：[[2,2,3],[7]]
 *
 * 【注意】标准的阶段划分
 * @author liusha
 * @date 2022/2/9
 */
public class Exercise09 {

    // 多阶段决策
    List<List<Integer>> res2 = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return new ArrayList<>();
        slove2(candidates, target, new ArrayList<>(), 0);
        return res2;
    }

    private void slove2(int[] candidates, int target, List<Integer> list, int i) {
        if (i == candidates.length || target <= 0) {
            if (target == 0) {
                res2.add(new ArrayList<>(list));
            }
            return;
        }

        // 不选
        slove2(candidates, target, list, i + 1);
        // 选
        list.add(candidates[i]);
        slove2(candidates, target - candidates[i], list, i);
        list.remove(list.size() - 1);
    }


    // ===== 方法分隔 ===


    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return new ArrayList<>();
        slove(candidates, target, new ArrayList<>(), 0);
        return res;
    }

    private void slove(int[] candidates, int target, List<Integer> list, int i) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) return;
        for (int j = i; j < candidates.length; j++) {
            list.add(candidates[j]);
            slove(candidates, target - candidates[j], list, j);
            list.remove(list.size() - 1);
        }
    }

}
