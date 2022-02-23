package cn.zl.algo.week10.dp.exercise.type01;

/**
 * 322 零钱兑换
 * @author liusha
 * @date 2022/2/23
 */
public class Exercise03 {
    public static void main(String[] args) {
        Exercise03 e = new Exercise03();
        int[] coins = {1};
        int amount = 0;
        System.out.println(e.coinChange(coins, amount));
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
