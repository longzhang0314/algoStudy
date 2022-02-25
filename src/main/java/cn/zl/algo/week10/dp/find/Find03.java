package cn.zl.algo.week10.dp.find;

/**
 * 1143.最长公共子序列
 * @author liusha
 * @date 2022/2/25
 */
public class Find03 {


    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m][n];
        boolean hasEqu = false;
        for (int i = 0; i < m; i++) {
            if (text1.charAt(i) == text2.charAt(0)) {
                hasEqu = true;
            }
            dp[i][0] = hasEqu ? 1 : 0;
        }
        hasEqu = false;
        for (int j = 0; j < n; j++) {
            if (text1.charAt(0) == text2.charAt(j)) {
                hasEqu = true;
            }
            dp[0][j] = hasEqu ? 1 : 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1] + 1);
                } else {
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
