package cn.zl.algo.week08.backtrack.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列2
 *
 * TODO do 重复
 * @author liusha
 * @date 2022/1/24
 */
public class Exercise08 {

    List<List<Integer>> res;
    boolean[] visited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        slove(nums, list);
        return res;
    }

    private void slove(int[] nums, List<Integer> list) {
        if (nums.length == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            // 前一个数没选，后一个也不能选，否则会是同一种情况
            // 前一个数选了，后一个可选可不选
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            list.add(nums[i]);
            visited[i] = true;
            slove(nums, list);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

}
