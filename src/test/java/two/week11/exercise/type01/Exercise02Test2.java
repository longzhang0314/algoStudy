package two.week11.exercise.type01;

/**
 * @author 流沙
 * @date 2024/3/5
 */
public class Exercise02Test2 {

    // 322: 最小硬币个数
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return amount == 0 ? 0 : -1;
        int n = coins.length;
        // climb model
        // 每一步选择coins中任意一个,达成i所需的最少个数
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                dp[i] = (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE)
                        ? Math.min(dp[i], dp[i - coin] + 1)
                        : dp[i];
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public int coinChang2(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return amount == 0 ? 0 : -1;
        int n = coins.length;
        // package model
        // 前i个
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i <= amount / coins[0]; i++) {
            dp[0][i * coins[0]] = i;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                for (int k = 0; k <= j / coins[i]; k++) {
                    if (dp[i - 1][j - k * coins[i]] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * coins[i]] + k);
                    }
                }
            }
        }
        return dp[n - 1][amount] != Integer.MAX_VALUE ? -1 : dp[n - 1][amount];
    }


//    public int coinChang3(int[] coins, int amount) {
//        if (coins == null || coins.length == 0) return amount == 0 ? 0 : -1;
//        int n = coins.length;
//        int[] dp = new int[amount + 1];
//        dp[0] = 0;
//        // 使用0个coin形成amount
//        for (int i = 1; i <= amount; i++) {
//            // 使用0个不可能组成amount >= 1
//            dp[i] = Integer.MAX_VALUE;
//        }
//
//    }
}
