package two.week08;

import java.util.ArrayList;
import java.util.List;

/**
 * 39
 * @author 流沙
 * @date 2023/8/12
 */
public class Exercise09Test2 {

    // 无重复数字，可重复选取；均大于0
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        slove2(candidates, target, res, list, 0);
        return res;
    }

    private void slove2(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int i) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (target < 0 || i == candidates.length) return;
        // i选/不选
        slove2(candidates, target, res, list, i + 1);
        list.add(candidates[i]);
        slove2(candidates, target - candidates[i], res, list, i);
        list.remove(list.size() - 1);
    }


    // 方法2：树的每层决策选哪个
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        slove(candidates, target, res, list, 0);
        return res;
    }

    private void slove(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int i) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            list.add(candidates[j]);
            slove(candidates, target - candidates[j], res, list, j);
            list.remove(list.size() - 1);
        }
    }
}
