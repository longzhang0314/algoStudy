package cn.zl.algo.week10.dp.common.pack.exercise.type03;

/**
 * @author liusha
 * @date 2022/4/8
 */
public class Exercise01Test {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], nums[i] > nums[j] ? dp[j] + 1 : 1);
            }
        }
        int max = 1;
        for (int d : dp) {
            max = Math.max(d, max);
        }
        return max;
    }
}
