package cn.zl.algo.week10.dp.common.pack.complete;

/**
 * @author liusha
 * @date 2022/3/9
 */
public class Demo01Test {

    // 可装最大值
    public int max(int[] weight, int w) {
        int n = weight.length;
        boolean[][] dp = new boolean[n][w + 1];
        for (int k = 0; k <= w / weight[0]; k++) {
            dp[0][k * weight[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                int cnt = j / weight[i];
                for (int k = 0; k <= cnt; k++) {
                    if (dp[i -1][j - k * weight[i]]) {
                        dp[i][j] = true;
                        break;
                    }
                }
            }
        }
        for (int j = w; j >= 0; j--) {
            if (dp[n - 1][j]) return j;
        }
        return 0;
    }
}
