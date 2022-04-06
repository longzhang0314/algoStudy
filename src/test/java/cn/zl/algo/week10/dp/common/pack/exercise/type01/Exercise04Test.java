package cn.zl.algo.week10.dp.common.pack.exercise.type01;

/**
 * @author liusha
 * @date 2022/4/6
 */
public class Exercise04Test {

    public int cuttingRope(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[n];
    }
}
