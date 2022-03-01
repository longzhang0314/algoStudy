package cn.zl.algo.week10.dp.common.pack.complete;

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
        for (int k = 0; k <= w / weight[0]; k++) {
            dp[0][k * weight[0]] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                int count = w / weight[i];
                for (int k = 0; k <= count; k++) {
                    dp[i][j] += dp[i - 1][j - k * weight[i]];
                }
            }
        }
        return dp[n - 1][w];
    }

}
