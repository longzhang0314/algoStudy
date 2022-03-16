package cn.zl.algo.week10.dp.common.pack.exercise.type03;

/**
 * @author liusha
 * @date 2022/3/16
 */
public class Exercise05Test {


    // freeze after sale
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // dp[i][0]: 持有
        // dp[i][1]: 今天刚卖出
        // dp[i][2]: 昨天刚卖出，冷冻期
        // dp[i][3]: 非冷冻期
        int[][] dp = new int[n][4];
        dp[0][0] = -prices[0];
        dp[0][3] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][3], dp[i - 1][2]) - prices[i]);
            dp[i][1] = dp[i][0] + prices[i];
            dp[i][2] = dp[i - 1][1];
            dp[i][3] = Math.max(dp[i - 1][2], dp[i - 1][3]);
        }
        return max1(dp[n - 1][0], dp[n - 1][1], dp[n - 1][2], dp[n - 1][3]);
    }

    private int max1(int a, int b, int c, int d) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        if (d > max) max = d;
        return max;
    }
}
