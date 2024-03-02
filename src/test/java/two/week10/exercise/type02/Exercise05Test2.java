package two.week10.exercise.type02;

import java.util.List;

/**
 * @author: longzhang
 * @date: 2024/3/2
 */
public class Exercise05Test2 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = triangle.get(i).get(j);
                if (j == 0) {
                    dp[i][j] += dp[i - 1][j];
                    continue;
                }
                if (j == triangle.get(i).size() - 1) {
                    dp[i][j] += dp[i - 1][j - 1];
                    continue;
                }
                dp[i][j] = dp[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[n - 1][j]);
        }
        return min;
    }
}
