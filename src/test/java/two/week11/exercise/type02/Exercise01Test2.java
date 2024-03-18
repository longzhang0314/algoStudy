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
                if (text1.charAt(i) == text2.charAt(j)) {
                    // 这里的dp[i - 1][j]和dp[i][j - 1]为什么不加1 ？与正向推导过程有关
                    // 正向推导过程：
                    // （1）如果(i,j)匹配，那么直接到(i+1,j+1)，且匹配个数+1；
                    // （2）如果(i,j)不匹配，那么到(i,j+1)或(i+1,j)，个数不变；
                    // 所以可得（i,j）的动态规划递推公示，即为上述三种情况反向而来；
                    // 优化：
                    // dp(i+1,j+1)一定是大于等于(i,j+1)或(i+1,j)，所以递推公式亦然，可以只由dp[i - 1][j - 1] + 1而来；
                    // 仅从动态规划递推公式来看，dp[i - 1][j - 1] + 1也一定大于等于dp[i][j - 1], dp[i - 1][j]
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 这里为什么没有dp[i - 1][j - 1] ？因为dp[i - 1][j - 1]一定小于另外两个状态，当然也可以加上
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
