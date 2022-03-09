package cn.zl.algo.week10.dp.common.pack.complete;

/**
 * @author liusha
 * @date 2022/3/9
 */
public class Demo03Test {

    // 正好装满
    public int min(int[] weight, int w) {
        int n = weight.length;
        int[][] dp = new int[n][w + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int k = 0; k <= w / weight[0]; k++) {
            dp[0][k * weight[0]] = k;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                int cnt = j / weight[i];
                for (int k = 0; k <= cnt; k++) {
                    if (dp[i - 1][j - k * weight[i]] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * weight[i]] + k);
                    }
                }
            }
        }

        return dp[n - 1][w] == Integer.MAX_VALUE ? - 1: dp[n - 1][w];
    }
}
