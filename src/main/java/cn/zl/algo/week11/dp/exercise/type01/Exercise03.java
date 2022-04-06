package cn.zl.algo.week11.dp.exercise.type01;

/**
 * 518.零钱兑换2
 * 硬币组合数
 *
 * 爬楼梯模型（注意与真正的爬楼梯的区别）+完全背包 两种做法
 *
 * @author liusha
 * @date 2022/2/28
 */
public class Exercise03 {

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
    public int change2(int amount, int[] coins) {
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

    public int change(int amount, int[] coins) {
        if (amount == 0) return 1;
        int[] dp = new int[amount + 1];
        // 用前0个coin凑成amount
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i - coin == 0) dp[i]++;
                if (i - coin > 0) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }
}
