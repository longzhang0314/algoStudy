package cn.zl.algo.week08.backtrack.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 *
 * @author liusha
 * @date 2022/1/24
 */
public class Exercise07 {

    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        slove(nums, list);
        return res;
    }

    private void slove(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 这里是否可以优化时间复杂度？
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            slove(nums, list);
            list.remove(list.size() - 1);
        }
    }
}
