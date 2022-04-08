package cn.zl.algo.week10.dp.common.pack.exercise.type02;

/**
 * @author liusha
 * @date 2022/4/8
 */
public class Exercise02Test {


    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m == 0) return n;
        if (n == 0) return m;
        int[][] dp = new int[m][n];
        dp[0][0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] < i || word1.charAt(i) != word2.charAt(0) ? dp[i - 1][0] + 1 : dp[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] < j || word1.charAt(0) != word2.charAt(j) ? dp[0][j - 1] + 1 : dp[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    private int min(int a, int b, int c) {
        int min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        return min;
    }

}
