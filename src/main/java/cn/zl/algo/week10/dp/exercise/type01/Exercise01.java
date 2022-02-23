package cn.zl.algo.week10.dp.exercise.type01;

/**
 * 416. 分割等和子集
 *
 * @author liusha
 * @date 2022/2/23
 */
public class Exercise01 {

    public static void main(String[] args) {
        Exercise01 e = new Exercise01();
//        int[] arr = {1,2,5};
        int[] arr = {100};
        System.out.println(e.canPartition(arr));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        sum /= 2;
        boolean[][] dp = new boolean[nums.length][sum + 1];
        dp[0][0] = true;
        if (nums[0] <= sum) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (dp[i - 1][j] || (j - nums[i] >= 0 && dp[i - 1][j - nums[i]])) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[nums.length - 1][sum];
    }

}
