package cn.zl.algo.week11.dp.exercise.type02;

/**
 * 72.编辑距离
 *
 * @author liusha
 * @date 2022/3/1
 */
public class Exercise02 {

    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m][n];
        if (word1.charAt(0) != word2.charAt(0)) {
            dp[0][0] = 1;
        }
        boolean equ = dp[0][0] == 0;
        for (int i = 1; i < m; i++) {
            if (equ) {
                dp[i][0] = dp[i - 1][0] + 1;
            } else {
                if (word1.charAt(i) == word2.charAt(0)) {
                    dp[i][0] = dp[i - 1][0];
                } else {
                    dp[i][0] = dp[i - 1][0] + 1;
                }
            }
            equ |= word1.charAt(i) == word2.charAt(0);
        }
        equ = dp[0][0] == 0;
        for (int j = 1; j < n; j++) {
            if (equ) {
                dp[0][j] = dp[0][j - 1] + 1;
            } else {
                if (word1.charAt(0) == word2.charAt(j)) {
                    dp[0][j] = dp[0][j - 1];
                } else {
                    dp[0][j] = dp[0][j - 1] + 1;
                }
            }
            equ |= word1.charAt(0) == word2.charAt(j);
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
