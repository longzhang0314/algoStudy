package cn.zl.algo.week10.dp.common.pack.zeroone;

/**
 * @author liusha
 * @date 2022/3/9
 */
public class Demo02Test {

    // 能否full
    public boolean full(int[] weight, int w) {
        int n = weight.length;
        boolean[][] dp = new boolean[n][w + 1];
        dp[0][0] = true;
        if (weight[0] <= w) {
            dp[0][weight[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (dp[i - 1][j] || (j - weight[i] >= 0 && dp[i - 1][j - weight[i]])) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[n - 1][w];
    }
}
