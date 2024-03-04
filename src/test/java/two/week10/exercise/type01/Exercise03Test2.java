package two.week10.exercise.type01;

/**
 * @author 流沙
 * @date 2024/1/4
 */
public class Exercise03Test2 {

    //322.least full pack
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        // dp定义：凑够金额i时需要的最小硬币个数
        // 递推公式：dp[i] = min(dp[i-coins[j]]) + 1
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                dp[i] = Math.min(dp[i], i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE ? dp[i - coin] + 1 : Integer.MAX_VALUE);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
