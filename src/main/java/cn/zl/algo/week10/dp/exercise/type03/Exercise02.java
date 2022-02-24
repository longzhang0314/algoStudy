package cn.zl.algo.week10.dp.exercise.type03;

/**
 * 213. 打家劫舍2
 * @author liusha
 * @date 2022/2/24
 */
public class Exercise02 {



    public int rob(int[] nums) {
        int n = nums.length;
        //i 第几家， j 偷/不偷， k 第0家 偷/不偷 --> 1/0
        int[][][] dp = new int[n][2][];
        dp[0][1][1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][1][0]);
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][1][1]);
            dp[i][1][0] = dp[i - 1][0][0] + nums[i];
            dp[i][1][1] = i == n - 1 ? 0 : (dp[i - 1][0][1] + nums[i]);
        }
        return max(dp[n - 1][0][0], dp[n - 1][0][1], dp[n - 1][1][0], dp[n - 1][1][1]);
    }


    public int rob2(int[] nums) {
        int n = nums.length;
        // 当前不偷，第0家不偷
        int dp00 = 0;
        // 当前不偷，第0家偷
        int dp01 = 0;
        // 当前偷，第0家不偷
        int dp10 = 0;
        // 当前偷，第0家偷
        int dp11 = nums[0];

        for (int i = 1; i < n; i++) {
            int dp0_00 = Math.max(dp00, dp10);
            int dp0_01 = Math.max(dp01, dp11);
            int dp0_10 = dp00 + nums[i];
            int dp0_11 = i == n - 1 ? 0 : dp01 + nums[i];

            dp00 = dp0_00;
            dp01 = dp0_01;
            dp10 = dp0_10;
            dp11 = dp0_11;
        }
        return max(dp00, dp01, dp10, dp11);
    }


    private int max(int a, int b, int c, int d) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        if (d > max) max = d;
        return max;
    }
}
