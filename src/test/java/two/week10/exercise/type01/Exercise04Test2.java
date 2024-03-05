package two.week10.exercise.type01;

/**
 * @author 流沙
 * @date 2024/2/2
 */
public class Exercise04Test2 {


    //给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
    //
    // 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
    //
    // 假设每一种面额的硬币有无限个。
    //
    // 题目数据保证结果符合 32 位带符号整数。
    //
    //
    //
    //
    //
    //
    // 示例 1：
    //
    //
    //输入：amount = 5, coins = [1, 2, 5]
    //输出：4
    //解释：有四种方式可以凑成总金额：
    //5=5
    //5=2+2+1
    //5=2+1+1+1
    //5=1+1+1+1+1
    //
    //
    // 示例 2：
    //
    //
    //输入：amount = 3, coins = [2]
    //输出：0
    //解释：只用面额 2 的硬币不能凑成总金额 3 。
    //
    //
    // 示例 3：
    //
    //
    //输入：amount = 10, coins = [10]
    //输出：1
    //
    //
    //
    //
    // 提示：
    //
    //
    // 1 <= coins.length <= 300
    // 1 <= coins[i] <= 5000
    // coins 中的所有值 互不相同
    // 0 <= amount <= 5000
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0 || amount <= 0) return amount == 0 ? 1 : 0;
        // 1.定义dp数组；
            // 二维：使用前i个硬币凑够j的组合数(i:0~coins.length-1)
            // 一维：凑够金额i的组合数（先二维）
        // 2.递推公式：
        // 二维：(思路：本次使用0-k个coins[i]组成，将所有dp[i-1][j-k*coins[i]]的组合数加起来即可)
        // dp[i][j] = for(k=0;k<=amount/coins[i];k++) dp[i][j] += dp[i-1][j-k*coins[i]]
        // 3.初始值:dp[]
        int[][] dp = new int[coins.length][amount + 1];
        for (int k = 0; k <= amount / coins[0]; k++) {
            dp[0][k * coins[0]]++;
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = 0;
                for (int k = 0; k <= amount / coins[i]; k++) {
                    dp[i][j] += (j - k * coins[i] >= 0 ? dp[i - 1][j - k * coins[i]] : 0);
                }
            }
        }
        return dp[coins.length - 1][amount];
    }


    public static void main(String[] args) {
        Exercise04Test2 e = new Exercise04Test2();
        int amount = 5;
        int[] coins  = {1, 2, 5};
        int change = e.change(amount, coins); // 4
        System.out.println(change);
    }

}
