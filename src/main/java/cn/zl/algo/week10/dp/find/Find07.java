package cn.zl.algo.week10.dp.find;

/**
 *
 * 121.买卖股票的最佳时机
 *
 * @author liusha
 * @date 2022/3/11
 */
public class Find07 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        // 未持有
        dp[0][0] = 0;
        // 已持有
        dp[0][1] = -prices[0];
        // 已卖掉
        dp[0][2] = 0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(-prices[i], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][2]);
        }

        return Math.max(dp[n - 1][0], dp[n - 1][2]);
    }

}
