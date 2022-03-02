package cn.zl.algo.week10.dp.common.pack.multi;

/**
 * 装满背包有多少种装法
 * @author liusha
 * @date 2022/3/2
 */
public class Demo04 {

    public int fullCnt(int[] weight, int w, int[] count) {
        int n = weight.length;
        int[][] dp = new int[n][w + 1];
        for (int k = 0; k <= w / weight[0] && k <= count[0]; k++) {
            dp[0][k * weight[0]] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                int cnt = Math.min(j / weight[i], count[i]);
                for (int k = 0; k <= cnt; k++) {
                    dp[i][j] += dp[i - 1][j - k * weight[i]];
                }
            }
        }
        return dp[n - 1][w];
    }


}
