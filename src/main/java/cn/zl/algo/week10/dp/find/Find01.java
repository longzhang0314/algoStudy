package cn.zl.algo.week10.dp.find;

/**
 * 5.最长回文子串
 *
 * 任意一个最长即可
 * @author liusha
 * @date 2022/2/25
 */
public class Find01 {


    // 思路：[i,j]为回文子串，那么[i+1,j-1]也是回文子串
    public String longestPalindrome(String s) {
        // [i,j] = [i+1,j-1]，且s[i]=s[j]
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        String res = s.substring(0, 1);
        // k:跨度，从2开始，递推
        for (int k = 2; k <= n; k++) {
            boolean hasFound = false;
            for (int i = 0; i <= n - k; i++) {
                int j = i + k - 1;
                int x = i + 1;
                int y = j - 1;
                if ((x > y || dp[x][y]) && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if (!hasFound) {
                        res = s.substring(i, j + 1);
                        hasFound = true;
                    }
                }
            }
        }

        return res;
    }
}
