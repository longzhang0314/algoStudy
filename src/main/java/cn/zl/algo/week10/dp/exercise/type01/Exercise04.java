package cn.zl.algo.week10.dp.exercise.type01;

/**
 * 518 零钱兑换2
 *
 * 有几种凑法
 *
 * 完全背包
 * @author liusha
 * @date 2022/2/23
 */
public class Exercise04 {
    public static void main(String[] args) {
        Exercise04 e = new Exercise04();
        int[] coins = {1,2,5};
        int amount = 5;
        System.out.println(e.change(amount, coins));
    }

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
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i == coin) dp[i] += 1;
                if (i - coin > 0 && dp[i - coin] > 0) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }
}
