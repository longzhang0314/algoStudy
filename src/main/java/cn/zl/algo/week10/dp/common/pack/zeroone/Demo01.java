package cn.zl.algo.week10.dp.common.pack.zeroone;

/**
 * 0-1背包
 * 背包可装物品总重量的最大值
 *
 * @author: longzhang
 * @date: 2022/3/1
 */
public class Demo01 {


    public int max(int[] weight, int w) {
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
        for (int j = w; j >= 0; j--) {
            if (dp[n - 1][j]) return j;
        }
        return 0;
    }

}
