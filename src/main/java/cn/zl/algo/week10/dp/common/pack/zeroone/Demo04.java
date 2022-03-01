package cn.zl.algo.week10.dp.common.pack.zeroone;

/**
 * 装满背包有多少种装法
 *
 * @author: longzhang
 * @date: 2022/3/1
 */
public class Demo04 {

    public int fullCnt(int[] weight, int w) {
        int n = weight.length;
        int[][] dp = new int[n][w + 1];
        dp[0][0] = 1;
        if (weight[0] <= w) {
            dp[0][weight[0]] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                dp[i][j] += dp[i - 1][j];
                if (j - weight[i] >= 0) {
                    dp[i][j] += dp[i - 1][j - weight[i]];
                }
            }
        }
        return dp[n - 1][w];
    }
}
