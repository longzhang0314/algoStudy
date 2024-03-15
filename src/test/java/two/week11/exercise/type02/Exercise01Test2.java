package two.week11.exercise.type02;

/**
 * @author 流沙
 * @date 2024/3/15
 */
public class Exercise01Test2 {

    public static void main(String[] args) {
        Exercise01Test2 e = new Exercise01Test2();
        System.out.println(e.longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
    }

    // 1143
    // 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
    // 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
    //
    // 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
    // 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
    // 示例 1：
    //
    //输入：text1 = "abcde", text2 = "ace"
    //输出：3
    //解释：最长公共子序列是 "ace" ，它的长度为 3 。
    //
    // 示例 2：
    //输入：text1 = "abc", text2 = "abc"
    //输出：3
    //解释：最长公共子序列是 "abc" ，它的长度为 3 。

//    测试用例:"bsbininm"
//            "jmjkbkjkv"
//    测试结果:2
//    期望结果:1
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) return 0;
        int m = text1.length(), n = text2.length();
        // 考察到第i、j时的最长公共子序列
        int[][] dp = new int[m][n];
        dp[0][0] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] == 1 ? 1 : text1.charAt(i) == text2.charAt(0) ? 1 : 0;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] == 1 ? 1 : text1.charAt(0) == text2.charAt(j) ? 1 : 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1]);
                dp[i][j] += text1.charAt(i) == text2.charAt(j) ? 1 : 0;
            }
        }
        // TODO 最新
        return dp[m - 1][n - 1];
    }
}
