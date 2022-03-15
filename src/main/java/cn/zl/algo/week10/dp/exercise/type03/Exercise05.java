package cn.zl.algo.week10.dp.exercise.type03;

/**
 * 309.最佳买卖股票时机含冷冻期
 *
 * TODO do late 重试，或二维数组（4种情况），貌似没有三维数组好理解
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


    // 空间优化
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        // 不持有，未冻结
        int dp00 = 0;
        // 不持有，冻结
        int dp01 = 0;
        // 持有，未冻结
        int dp10 = -prices[0];
        // 持有，冻结   (卖出才冻结，不符合条件就0)
        int dp11 = 0;

        for (int i = 1; i < n; i++) {
            int dp0_00 = Math.max(dp00, dp01);
            int dp0_01 = dp10 + prices[i];
            int dp0_10 = Math.max(dp10, dp00 - prices[i]);
            // int dp0_11, 不可能由前一个状态进入当前持有且冻结的状态

            dp00 = dp0_00;
            dp01 = dp0_01;
            dp10 = dp0_10;
        }
        return Math.max(dp00, dp01);
    }


}
