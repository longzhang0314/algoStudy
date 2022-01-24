package cn.zl.algo.week08.backtrack.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90.子集2（有重复元素，但同一个位置不能重复使用）
 *
 * @author liusha
 * @date 2022/1/24
 */
public class Exercise06 {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        slove(nums, list, 0);
        return res;
    }

    private void slove(int[] nums, List<Integer> list, int i) {
        res.add(new ArrayList<>(list));
        for (int j = i; j < nums.length; j++) {
            // 重复情况过滤
            if (j > i && nums[j] == nums[j - 1]) continue;
            list.add(nums[j]);
            // 不允许元素重复放入
            slove(nums, list, j + 1);
            list.remove(list.size() - 1);
        }
    }

}
