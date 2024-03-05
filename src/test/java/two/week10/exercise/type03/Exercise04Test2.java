package two.week10.exercise.type03;

/**
 * @author 流沙
 * @date 2024/3/4
 */
public class Exercise04Test2 {

    // 714
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        // 1:当前持有
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        // 买入时算手续费
        dp[0][1] = prices[0] - fee;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] -fee);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
