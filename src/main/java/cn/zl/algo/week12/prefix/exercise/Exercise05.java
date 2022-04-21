package cn.zl.algo.week12.prefix.exercise;

/**
 * 53. 最大子数组和
 *
 * 已做：DP法
 * TODO do late 前缀后缀统计、滑动窗口：两种都要再练下
 *
 * 前缀后缀如何想到：由暴力法优化而来，两步优化，从时间复杂度考虑
 * @author liusha
 * @date 2022/3/29
 */
public class Exercise05 {

    // 方法1：dp，前缀和
    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }



}
