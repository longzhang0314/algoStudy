package cn.zl.algo.week12.prefix.exercise;

/**
 * 面试题 05.03 翻转数位
 * @author liusha
 * @date 2022/3/29
 */
public class Exercise03 {

    public int reverseBits(int num) {
        // 0:不使用替换；1:使用替换
        int[][] dp = new int[32][2];
        dp[0][0] = ((num & 1) == 1) ? 1 : 0;
        dp[0][1] = ((num & 1) == 1) ? -1 : 1;
        for (int i = 1; i < 32; i++) {
            boolean curOne = (num & (1 << i)) != 0;

            if (curOne) {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1] == -1 ? -1 : dp[i - 1][1] + 1;
            } else {
                dp[i][0] = 0;
                dp[i][1] = dp[i - 1][0] + 1;
            }
        }
        int max = 0;
        for (int i = 0; i < 32; i++) {
            max = Math.max(max, dp[i][0]);
            max = Math.max(max, dp[i][1]);
        }
        return max;
    }


}
