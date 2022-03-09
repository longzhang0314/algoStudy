package cn.zl.algo.week10.dp.common.pack.complete;

/**
 * @author liusha
 * @date 2022/3/9
 */
public class Demo04Test {

    // 装满方法数
    public int fullCnt(int[] weight, int w) {
        int n = weight.length;
        int[][] dp = new int[n][w + 1];
        for (int k = 0; k <= w / weight[0]; k++) {
            dp[0][k * weight[0]]++;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                int cnt = j / weight[i];
                for (int k = 0; k <= cnt; k++) {
                    dp[i][j] += dp[i - 1][j - k * weight[i]];
                }
            }
        }
        return dp[n - 1][w];
    }
}
