package cn.zl.algo.week10.dp.common.pack.exercise.type01;

/**
 * @author liusha
 * @date 2022/4/6
 */
public class Exercise05Test {

    // 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”
    // 有多少种不同翻译方法 爬楼梯
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int n = str.length();
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1];
            if (isValid(str, i - 1, i)) {
                dp[i] += i > 1 ? dp[i - 2] : 1;
            }
        }
        return dp[n - 1];
    }

    private boolean isValid(String str, int i, int j) {
        if (str.charAt(i) == '0') return false;
        int digit = 0;
        digit += (str.charAt(i) - '0');
        digit = digit * 10 + (str.charAt(j) - '0');

        return digit <= 25;
    }
}
