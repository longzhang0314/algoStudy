package cn.zl.algo.week10.dp.common.pack.exercise.type01;

/**
 * @author liusha
 * @date 2022/4/6
 */
public class Exercise03Test {


    // 硬币组合数: 爬楼梯模型
    public int change3(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i - coin >= 0) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }


    // 硬币组合数: 完全背包
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int k = 0; k <= amount / coins[0]; k++) {
            dp[0][k * coins[0]] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                int cnt = j / coins[i];
                for (int k = 0; k <= cnt; k++) {
                    dp[i][j] += dp[i - 1][j - k * coins[i]];
                }
            }
        }
        return dp[n - 1][amount];
    }
}
