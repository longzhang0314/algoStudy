package cn.zl.algo.week08.backtrack.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 *
 * @author liusha
 * @date 2022/1/24
 */
public class Exercise05 {

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
