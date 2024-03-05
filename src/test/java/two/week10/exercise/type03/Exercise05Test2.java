package two.week10.exercise.type03;

/**
 * @author 流沙
 * @date 2024/3/5
 */
public class Exercise05Test2 {

    // 309：卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 0:未冻结，1:冻结
        int[][][] dp = new int[n][2][2];
        dp[0][1][0] = prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][0][1]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][0] - prices[i]);
            dp[i][0][1] = dp[i - 1][1][0] + prices[i];
        }
        return Math.max(dp[n - 1][0][0], dp[n - 1][0][1]);
    }


    public int maxProfit2(int[] prices) {
        int n = prices.length;
        //0:持有未冻结；1:未持有未冻结；2:未持有冻结
        int dp_0 = -prices[0];
        int dp_1 = 0;
        int dp_2 = 0;
        for (int i = 1; i < n; i++) {
            int dp_00 = Math.max(dp_0, dp_1 - prices[i]);
            int dp_11 = Math.max(dp_1, dp_2);
            int dp_22 = dp_0 + prices[i];

            dp_0 = dp_00;
            dp_1 = dp_11;
            dp_2 = dp_22;
        }
        return Math.max(dp_1, dp_2);
    }
}
