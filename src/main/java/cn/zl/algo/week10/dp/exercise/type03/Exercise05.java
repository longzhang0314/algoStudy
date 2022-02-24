package cn.zl.algo.week10.dp.exercise.type03;

/**
 * 309.最佳买卖股票时机含冷冻期
 *
 * @author liusha
 * @date 2022/2/24
 */
public class Exercise05 {

    public static void main(String[] args) {
        Exercise05 e = new Exercise05();
        int[] prices = {1, 2, 4};
        System.out.println(e.maxProfit(prices)); // 3
    }


    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 考察到第i个；0/1:不持有/持有；0/1:未冻结/冻结
        int[][][] dp = new int[n][2][2];
        dp[0][1][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][0][1]);
            dp[i][0][1] = dp[i - 1][1][0] + prices[i];
            dp[i][1][0] = Math.max(dp[i - 1][0][0] - prices[i], dp[i - 1][1][0]);
        }
        return Math.max(dp[n - 1][0][0], dp[n - 1][0][1]);
    }


}
