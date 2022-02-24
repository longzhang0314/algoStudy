package cn.zl.algo.week10.dp.exercise.type03;

/**
 * 714.买卖股票的最佳时机含手续费
 *
 * @author liusha
 * @date 2022/2/24
 */
public class Exercise04 {

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        // 0/1 不持有/持有
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        // 买入时交手续费
        dp[0][1] = -prices[0] -fee;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }


    // 空间优化
    public int maxProfit2(int[] prices, int fee) {
        int n = prices.length;
        int dp0 = 0;
        int dp1 = -prices[0] - fee;
        for (int i = 1; i < n; i++) {
            int dp00 = Math.max(dp0, dp1 + prices[i]);
            int dp11 = Math.max(dp1, dp0 - prices[i] - fee);

            dp0 = dp00;
            dp1 = dp11;
        }
        return Math.max(dp0, dp1);
    }
}
