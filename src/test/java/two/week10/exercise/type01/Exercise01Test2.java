package two.week10.exercise.type01;


/**
 * 416
 * @author 流沙
 * @date 2023/12/20
 */
public class Exercise01Test2 {

    public static void main(String[] args) {
        Exercise01Test2 e = new Exercise01Test2();
        int[] nums = {1,5,11,5};
//        int[] nums = {1,2,5};
        // expect true
        System.out.println(e.canPartition(nums));
    }


    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        // 如果是奇数，false
        // 如果是偶数，凑1/2即可，凑1/2的过程动态规划
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        if (nums[0] <= sum) dp[nums[0]] = true;

        for (int i = 1; i < nums.length; i++) {
//            for (int j = 0; j <= sum; j++) {
//                // 会在同一层重复选取，所以需要修改for为倒序遍历，这也是空间优化的常见手段
//                if (j - nums[i] >= 0 && dp[j - nums[i]]) {
//                    dp[j] = true;
//                }
//            }
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i] >= 0 && dp[j - nums[i]]) dp[j] = true;
            }
        }
        return dp[sum];
    }


    // 二维
    public boolean canPartition2(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        // 如果是奇数，false
        // 如果是偶数，凑1/2即可，凑1/2的过程动态规划
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) return false;
        sum /= 2;

        // 考虑完前m-1个元素后，能够到达的sum
        // 当前i这个元素，可要可不要
        // dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]
        boolean[][] dp = new boolean[nums.length][sum + 1];
        dp[0][0] = true;
        if (nums[0] <= sum) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                } else if (j - nums[i] >= 0 && dp[i - 1][j - nums[i]]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[nums.length - 1][sum];
    }
}
