package cn.zl.algo.week10.dp.common.pack.zeroone;

/**
 * 正好装满背包最少需要多少物品
 *
 * @author: longzhang
 * @date: 2022/3/1
 */
public class Demo03 {

    public int min(int[] weight, int w) {
        int n = weight.length;
        int[][] dp = new int[n][w + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        if (weight[0] <= w) {
            dp[0][weight[0]] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - weight[i] >= 0 && dp[i - 1][j - weight[i]] < Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - weight[i]] + 1);
                }
            }
        }
        return dp[n - 1][w] == Integer.MAX_VALUE ? - 1 : dp[n - 1][w];
    }
}
