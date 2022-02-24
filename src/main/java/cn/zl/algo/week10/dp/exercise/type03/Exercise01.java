package cn.zl.algo.week10.dp.exercise.type03;

/**
 * 198. 打家劫舍
 *
 * @author liusha
 * @date 2022/2/23
 */
public class Exercise01 {


    // 方法1：2维DP
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }


    // 空间优化
    public int rob2(int[] nums) {
        int n = nums.length;
        int dp0 = 0;
        int dp1 = nums[0];
        for (int i = 1; i < n; i++) {
            int dp00 = Math.max(dp0, dp1);
            int dp11 = dp0 + nums[i];

            dp0 = dp00;
            dp1 = dp11;
        }
        return Math.max(dp0, dp1);
    }
}
