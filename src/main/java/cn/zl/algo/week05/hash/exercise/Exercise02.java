package cn.zl.algo.week05.hash.exercise;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 15. 三数之和（中等）
 *
 * @author: longzhang
 * @date: 2021/12/29
 */
public class Exercise02 {

    public static void main(String[] args) {
        Exercise02 e = new Exercise02();
        int[] nums = {-1,0,1,2,-1,-4};
        // -4,-1,-1,0,1,2
        List<List<Integer>> lists = e.threeSum(nums);
        System.out.println(JSON.toJSONString(lists));
    }


    // -1,0,1,2,-1,-4
    // 方法1：哈希
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int remain = -(nums[i] + nums[j]);
                if (map.containsKey(remain)) {
                    int k = map.get(remain);
                    if (k > j) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return res;
    }

    // 方法2：双指针
    public List<List<Integer>> threeSum2(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = n - 1;
            while (j < k) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                if (k < n - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }

}
