package two.week11.exercise.type01;

/**
 * @author 流沙
 * @date 2024/3/11
 */
public class Exercise03Test2 {

    public static void main(String[] args) {
        Exercise03Test2 e = new Exercise03Test2();
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(e.change(amount, coins)); // 4

//        int amount = 10;
//        int[] coins = {10};
//        System.out.println(e.change(amount, coins)); // 1

    }

    // climb解法：
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) return amount == 0 ? 1 : 0;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                dp[i] += (i >= coin ? dp[i - coin] : 0);
            }
        }
        return dp[amount];
    }

    // 518：组合数
    // 背包解法：使用前i个硬币凑够金额为j的组合数
    public int change3(int amount, int[] coins) {
        if (coins == null || coins.length == 0) return amount == 0 ? 1 : 0;
        // 使用前i个硬币凑够金额为j的组合数
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            // 任何硬币凑够金额0都只有1种组合
            dp[i][0] = 1;
        }
        for (int k = 1; k <= amount / coins[0]; k++) {
            dp[0][k * coins[0]]++;
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                for (int k = 0; k <= j / coins[i]; k++) {
                    dp[i][j] += dp[i - 1][j - k * coins[i]];
                }
            }
        }
        return dp[coins.length - 1][amount];
    }
}