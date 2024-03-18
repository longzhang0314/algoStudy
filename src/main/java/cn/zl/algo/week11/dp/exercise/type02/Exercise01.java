package cn.zl.algo.week11.dp.exercise.type02;

/**
 * 1143.最长公共子序列
 *
 * @author liusha
 * @date 2022/3/1
 */
public class Exercise01 {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m][n];
        if (text1.charAt(0) == text2.charAt(0)) {
            dp[0][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] == 1 ? 1 : text1.charAt(i) == text2.charAt(0) ? 1 : 0;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] == 1 ? 1 : text1.charAt(0) == text2.charAt(j) ? 1 : 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    // dp[i][j] = dp[i - 1][j - 1] + 1;可行

                    // 这里的dp[i - 1][j]和dp[i][j - 1]为什么不加1 ？与正向推导过程有关
                    // 正向推导过程：
                    // （1）如果(i,j)匹配，那么直接到(i+1,j+1)，且匹配个数+1；
                    // （2）如果(i,j)不匹配，那么到(i,j+1)或(i+1,j)，个数不变；
                    // 所以可得（i,j）的动态规划递推公示，即为上述三种情况反向而来；
                    // 优化：
                    // dp(i+1,j+1)一定是大于等于(i,j+1)或(i+1,j)，所以递推公式亦然，可以只由dp[i - 1][j - 1] + 1而来；
                    // 仅从动态规划递推公式来看，dp[i - 1][j - 1] + 1也一定大于等于dp[i][j - 1], dp[i - 1][j]
                    dp[i][j] = max(dp[i - 1][j - 1] + 1, dp[i - 1][j], dp[i][j - 1]);
                } else {
                    // 这里为什么没有dp[i - 1][j - 1] ？因为dp[i - 1][j - 1]一定小于另外两个状态
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    private int max(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }
}
