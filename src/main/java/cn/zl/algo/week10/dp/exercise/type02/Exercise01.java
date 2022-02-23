package cn.zl.algo.week10.dp.exercise.type02;

/**
 * 62. 不同路径
 *
 * @author liusha
 * @date 2022/2/23
 */
public class Exercise01 {


    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]  = dp[i][j] + dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
