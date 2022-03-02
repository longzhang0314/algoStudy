package cn.zl.algo.week10.dp.common.pack.multi;

/**
 * 多重背包
 * 背包可装物品总重量的最大值
 *
 * @author liusha
 * @date 2022/3/2
 */
public class Demo01 {

    /**
     *
     * @param weight
     * @param w
     * @param count weight[i]对应物品最大可装个数
     * @return
     */
    public int max(int[] weight, int w, int[] count) {
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
        for (int j = w; j >= 0; j--) {
            if (dp[n - 1][j]) return j;
        }
        return 0;
    }
}
