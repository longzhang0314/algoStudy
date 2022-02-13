package cn.zl.algo.week08.backtrack.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 *
 * TODO do 用多阶段决策模型的方式来写，另外几道题也一样，后续补充
 *
 * @author liusha
 * @date 2022/1/24
 */
public class Exercise05 {

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        slove2(nums, res, list, 0);
        return res;
    }

    private void slove2(int[] nums, List<List<Integer>> res, List<Integer> list, int i) {
        if (i == nums.length) {
            res.add(new ArrayList<>());
            return;
        }

        slove2(nums, res, list, i + 1);

        list.add(nums[i]);
        slove2(nums, res, list, i + 1);
        list.remove(list.size() - 1);
    }

    // =================================================================================================

    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        slove(nums, list, 0);
        return res;
    }

    private void slove(int[] nums, List<Integer> list, int i) {
        res.add(new ArrayList<>(list));
        for (int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            slove(nums, list, j + 1);
            list.remove(list.size() - 1);
        }
    }
}
