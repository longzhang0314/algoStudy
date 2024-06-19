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


    // 方法0：暴力法
    public int maxSubArray0(int[] nums) {
        // method1: force
        // 暴力法：拿到当前元素，向左延伸拿到最大值，向右延伸拿到最大值，且获得总和最大值
        if (nums == null || nums.length == 0) return 0;
        int res = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int leftMax = 0;
            int leftVal  = 0;
            for (int j = i - 1; j >= 0; j--) {
                leftVal += nums[j];
                if (leftVal > leftMax) leftMax = leftVal;
            }
            int rightMax = 0;
            int rightVal = 0;
            for (int k = i + 1; k < n; k++) {
                rightVal += nums[k];
                if (rightVal > rightMax) rightMax = rightVal;
            }
            res = Math.max(res, nums[i] + leftMax + rightMax);
        }
        return res;
    }


    // 方法2-1：dp，前缀和
    public int maxSubArray2(int[] nums) {
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

    // 方法2-2：前缀和（和方法2-1一致，仅写法略有差异）
    public int maxSubArray22(int[] nums) {
        // method2: 前缀后缀和：思路基于暴力法
        if (nums == null || nums.length == 0) return 0;
        int res = Integer.MIN_VALUE;
        int n = nums.length;
        // 包含当前值的连续子数组向左延伸的最大值
        int[] leftMax = new int[n];
        for (int i = 0; i < n; i++) {
            leftMax[i] = nums[i] + Math.max(0, (i > 0 ? leftMax[i - 1] : 0));
            res = Math.max(res, leftMax[i]);
        }
        return res;
    }



}
