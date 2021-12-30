package cn.zl.algo.week05.hash.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.两数之和
 *
 * @author: longzhang
 * @date: 2021/12/29
 */
public class Exercise01 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1) return new int[]{-1, -1};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

}
