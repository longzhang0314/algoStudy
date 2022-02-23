package cn.zl.algo.week10.dp.exercise.type01;

/**
 * 494.目标和
 *
 * @author liusha
 * @date 2022/2/23
 */
public class Exercise02 {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (target >= 0 && sum < target) {
            return 0;
        }
        if (target < 0 && -sum > target) {
            return 0;
        }
        // 考察完第i个元素后算式结果为j的个数
        // -sum在i=0的位置
        int[][] dp = new int[nums.length][sum * 2 + 1];
        if (-nums[0] + sum >= 0) {
            dp[0][-nums[0] + sum] = 1;
        }
        if (nums[0] + sum <= sum * 2) {
            dp[0][nums[0] + sum]++;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= sum * 2; j++) {
                if (j - nums[i] >= 0) {
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
                if (j + nums[i] <= sum * 2) {
                    dp[i][j] += dp[i - 1][j + nums[i]];
                }
            }
        }
        return dp[nums.length - 1][target + sum];
    }
}
