package cn.zl.algo.week11.dp.find;

/**
 * 674.最长连续递增序列
 *
 * @author liusha
 * @date 2022/3/2
 */
public class Find01 {


    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int max = 1;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
