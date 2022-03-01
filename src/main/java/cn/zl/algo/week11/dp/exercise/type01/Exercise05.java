package cn.zl.algo.week11.dp.exercise.type01;

/**
 * jzof 46
 *
 * //给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
 * //能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * //
 * // 示例 1:
 * // 输入: 12258
 * //输出: 5
 * //解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * //
 * // 提示：
 * // 0 <= num < 231
 * @author liusha
 * @date 2022/2/28
 */
public class Exercise05 {


    public int translateNum(int num) {
        if (num == 0) return 1;
        String numStr = String.valueOf(num);
        int n = numStr.length();

        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            // dp[i-1] + dp[i-2](i-1到i可以组成有效数字)
            dp[i] = dp[i - 1];
            if (isValid(numStr, i - 1, i)) {
                dp[i] += i > 1 ? dp[i - 2] : 1;
            }
        }
        return dp[n - 1];
    }

    private boolean isValid(String s, int i, int j) {
        if (s.charAt(i) == '0') return false;
        int digit = 0;
        digit += (s.charAt(i) - '0');
        digit = digit * 10 + (s.charAt(j) - '0');
        return digit >= 0 && digit <= 25;
    }


}
