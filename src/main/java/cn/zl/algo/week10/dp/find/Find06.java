package cn.zl.algo.week10.dp.find;

/**
 * 279. 完全平方数
 *
 * @author liusha
 * @date 2022/3/11
 */
public class Find06 {


    public int numSquares(int n) {
        // i is true -> f(i) = 1
        // x + y == n && x & y -> f(i) = 2;
        // f(n) = i & n-i  ->  f(i) * f(n-i)
        boolean[] bo = new boolean[n + 1];
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            if(isValid(i)) {
                bo[i] = true;
            }
            dp[i] = i;
        }
        for (int i = 2; i <= n; i++) {
            if (bo[i]) {
                dp[i] = 1;
                continue;
            }
            for (int j = 1; j < i; j++) {
                if (bo[j] && bo[i - j]) {
                    dp[i] = 2;
                    break;
                }
                dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
            }
        }
        return dp[n];
    }

    private boolean isValid(int n) {
        int left = 1;
        int right = (n - 1) / 2 + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid == n) return true;
            if (mid * mid < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
