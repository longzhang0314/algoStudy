package cn.zl.algo.week11.dp.exercise.type01;

/**
 * 322.零钱兑换
 * 最少硬币个数
 *
 * TODO do 重复 爬楼梯模型+完全背包 两种做法
 * @author liusha
 * @date 2022/2/28
 */
public class Exercise02 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        // 使用0个coin形成amount
        for (int i = 1; i <= amount; i++) {
            // 使用0个不可能组成amount >= 1
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
