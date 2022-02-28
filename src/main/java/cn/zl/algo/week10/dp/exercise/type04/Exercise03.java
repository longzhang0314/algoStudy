package cn.zl.algo.week10.dp.exercise.type04;

/**
 * 518.零钱兑换2
 *
 * TODO do 重复
 *
 * @author liusha
 * @date 2022/2/28
 */
public class Exercise03 {

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
