package cn.zl.algo.week10.dp.common.pack.complete;

/**
 * 完全背包
 * 背包可装物品总重量的最大值
 *
 * @author: longzhang
 * @date: 2022/3/1
 */
public class Demo01 {

    public int max(int[] weight, int w) {
        int n = weight.length;
        boolean[][] dp = new boolean[n][w + 1];
        for (int k = 0; k <= w / weight[0]; k++) {
            dp[0][weight[0] * k] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                int count = j / weight[i];
                for (int k = 0; k <= count; k++) {
                    if (dp[i - 1][j - k * weight[i]]) {
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
