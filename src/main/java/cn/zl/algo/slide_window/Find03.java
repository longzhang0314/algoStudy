package cn.zl.algo.slide_window;

/**
 * 209. 长度最小的子数组
 *
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组
 *
 * @author: longzhang
 * @date: 2021/12/23
 */
public class Find03 {

    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // 滑动窗口，当target <= 0时，满足条件
        int left = 0;
        int min = -1;
        for (int i = 0; i < nums.length; i++) {
            target -= nums[i];
            if (target <= 0) {
                while (left < i && target + nums[left] <= 0) {
                    target += nums[left++];
                }
                if (min == -1 || i - left + 1 < min) {
                    min = i - left + 1;
                }
                target += nums[left++];
            }
        }
        return min == -1 ? 0 : min;
    }
}
