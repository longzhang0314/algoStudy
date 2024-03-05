package two.week10.exercise.type03;

/**
 * @author 流沙
 * @date 2024/3/4
 */
public class Exercise02Test2 {

    // 收尾相连
    public int rob(int[] nums) {
        int n = nums.length;
        int[][][] dp = new int[n][2][2];
        dp[0][1][1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][1][0]);
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][1][1]);
            dp[i][1][0] = dp[i - 1][0][0] + nums[i];
            dp[i][1][1] = i == n - 1 ? 0 : (dp[i - 1][0][1] + nums[i]);
        }
        return max(dp[n - 1][0][0], dp[n - 1][0][1], dp[n - 1][1][0], dp[n - 1][1][1]);
    }

    private int max(int a, int b, int c, int d) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        if (d > max) max = d;
        return max;
    }
}
