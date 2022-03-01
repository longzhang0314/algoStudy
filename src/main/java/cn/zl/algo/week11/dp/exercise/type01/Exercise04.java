package cn.zl.algo.week11.dp.exercise.type01;

/**
 * 剑指 Offer 14- I . 剪绳子
 *
 * //给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * //请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * //
 * // 示例 1：
 * // 输入: 2
 * //输出: 1
 * //解释: 2 = 1 + 1, 1 × 1 = 1
 * //
 * // 示例 2:
 * // 输入: 10
 * //输出: 36
 * //解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * //
 * // 提示：
 * // 2 <= n <= 58
 *
 * @author liusha
 * @date 2022/2/28
 */
public class Exercise04 {

    public static void main(String[] args) {
        Exercise04 e = new Exercise04();
        System.out.println(e.cuttingRope(10));// 36
    }

    public int cuttingRope(int n) {
        // 每一段的长度是[1,n-1]，每一段的长度和加起来等于n，没有长度等于0的绳子
        // dp[i] = max(dp[j] * (i - j), j * (i - j), dp[i]) --> j范围[1,i-1]且dp[j] != 0， dp[1] = 1
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = max(dp[i], dp[j] > 0 ? dp[j] * (i - j) : 0, j * (i - j));
            }
        }
        return dp[n];
    }

    private int max(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }


}
