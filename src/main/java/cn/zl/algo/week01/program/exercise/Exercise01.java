package cn.zl.algo.week01.program.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和（简单）
 */
public class Exercise01 {

    /**
     * 最low的解法，O(N2)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return new int[]{-1, -1};
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 使用hash表存储考察过的数 O(N)
     *
     * 每次遍历到当前这个数时去查target-nums[i]是否在hash表中存在
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (map.containsKey(sub)) return new int[]{map.get(sub), i};
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
