package cn.zl.algo.week10.dp.common.pack.multi;

/**
 * @author liusha
 * @date 2022/3/9
 */
public class Demo02Test {

    public boolean full(int[] weight, int w, int[] count) {
        int n = weight.length;
        boolean[][] dp = new boolean[n][w + 1];
        for (int k = 0; k <= w / weight[0] && k <= count[0]; k++) {
            dp[0][k * weight[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                int cnt = Math.min(j / weight[i], count[i]);
                for (int k = 0; k <= cnt; k++) {
                    if (dp[i - 1][j - k * weight[i]]) {
                        dp[i][j] = true;
                        break;
                    }
                }
            }
        }

        return dp[n - 1][w];
    }
}
