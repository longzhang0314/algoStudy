package cn.zl.algo.week10.dp.find;

/**
 * 516.最长回文子序列
 *
 * @author liusha
 * @date 2022/2/25
 */
public class Find02 {

    // 思路：[i,j]为回文子串，那么[i+1,j-1]也是回文子串
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // [i,j] 这个范围内最长回文子串长度
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            // 1个字符本身就是回文串
            dp[i][i] = 1;
        }
        // 长度为2的字符串开始赋值
        for (int k = 2; k <= n; k++) {
            for (int i = 0; i <= n - k; i++) {
                int j = i + k - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = max(i < n && j > 0 && i + 1 <= j - 1 ? dp[i + 1][j - 1] + 2 : 2,
                            i + 1 <= j ? dp[i + 1][j] : 2, j > 0 && i <= j - 1 ? dp[i][j - 1] : 2);
                } else {
                    dp[i][j] = Math.max(i + 1 <= j ? dp[i + 1][j] : 1, j > 0 && i <= j - 1 ? dp[i][j - 1] : 1);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    private int max(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }
}
