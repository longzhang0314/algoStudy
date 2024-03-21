package two.week11.exercise.type02;

/**
 * @author 流沙
 * @date 2024/3/19
 */
public class Exercise02Test2 {

    public static void main(String[] args) {
        Exercise02Test2 e = new Exercise02Test2();
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(e.minDistance(word1, word2)); // 5
    }

    // 72.给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) return word2 == null ? 0 : word2.length();
        if (word2 == null || word2.length() == 0) return word1.length();
        int m = word1.length(), n = word2.length();
        // 三种操作：增、删、插
        // 定义：考察到[i][j]时的最小编辑距离
        // 状态转移：dp[i][j] = min(dp[i-1][j] + 1,dp[i][j-1] + 1,dp[i-1][j-1] + 1)
        int[][] dp = new int[m][n];
        dp[0][0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0]
                    + (dp[i - 1][0] == i && word1.charAt(i) == word2.charAt(0) ? 0 : 1);
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1]
                    + (dp[0][j - 1] == j && word1.charAt(0) == word2.charAt(j) ? 0 : 1);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 顺推思路，相等则直接向后i+1,j+1；不相等则三种方式向后平移
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]) + 1;
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
