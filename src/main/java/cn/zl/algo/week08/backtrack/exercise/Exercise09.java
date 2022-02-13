package cn.zl.algo.week08.backtrack.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 39.组合总和（中等）
 *
 * TODO do 标准的阶段划分
 * @author liusha
 * @date 2022/2/9
 */
public class Exercise09 {

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
