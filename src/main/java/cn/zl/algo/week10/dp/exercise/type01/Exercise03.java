package cn.zl.algo.week10.dp.exercise.type01;

/**
 * 322 零钱兑换
 * 最少需要多少个凑成
 *
 * 完全背包
 * @author liusha
 * @date 2022/2/23
 */
public class Exercise03 {
    public static void main(String[] args) {
        Exercise03 e = new Exercise03();
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(e.coinChange2(coins, amount));
    }


    public int coinChange2(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i = 1; i < n; i++) {
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


    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

}
