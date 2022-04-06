package cn.zl.algo.week10.dp.common.pack.exercise.type01;

/**
 * @author liusha
 * @date 2022/4/6
 */
public class Exercise02Test {


    // 最少硬币个数 爬楼梯模型
    // 每一步可以选择爬coins里面的任意一个，到达amount时的最小个数
    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            // 可选列表 coins
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }


    // 最少硬币个数 完全背包
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int k = 0; k <= amount / coins[0]; k++) {
            dp[0][k * coins[0]] = k;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                int cnt = j / coins[i];
                for (int k = 0; k <= cnt; k++) {
                    if (dp[i - 1][j - k * coins[i]] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * coins[i]] + k);
                    }
                }
            }
        }
        return dp[n - 1][amount] == Integer.MAX_VALUE ? -1 : dp[n - 1][amount];
    }
}
