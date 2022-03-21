package cn.zl.algo.week12.pointer.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题 16.24
 *
 * 设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。
 *
 * // 输入: nums = [5,6,5,6], target = 11
 * //输出: [[5,6],[5,6]]
 * @author liusha
 * @date 2022/3/21
 */
public class Exercise02 {

    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                res.add(Arrays.asList(nums[i], nums[j]));
                i++;
                j--;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

}
