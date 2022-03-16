package cn.zl.algo.week10.dp.find;

/**
 * 122.买卖股票的最佳时机2
 * @author liusha
 * @date 2022/3/14
 */
public class Find08 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
