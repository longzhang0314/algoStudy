package two.week10.exercise.type02;

/**
 * @author: longzhang
 * @date: 2024/3/2
 */
public class Exercise02Test2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        // 到达i,j这个位置的路径条数
        int[][] dp = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] == 0
                    ? 0
                    : obstacleGrid[i][0] == 0
                    ? 1 : 0;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] == 0
                    ? 0
                    : obstacleGrid[0][j] == 0
                    ? 1 : 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1
                        ? 0
                        : dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
