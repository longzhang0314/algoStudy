package two.week10.exercise.type01;

/**
 * @author 流沙
 * @date 2024/1/3
 */
public class Exercise02Test2 {

    public static void main(String[] args) {
        Exercise02Test2 e = new Exercise02Test2();
//        int[] nums = {1,1,1,1,1}; int target = 3; // except 5
        int[] nums = {1}; int target = 2; // except 0
        System.out.println(e.findTargetSumWays(nums, target));
    }

    // method1：2维dp，finish TODO 一维优化
    public int findTargetSumWays(int[] nums, int target) {
        // 已知：nums全部非负
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (target > sum || target < -sum) {
            return 0;
        }

        // 定义：考察到第i个元素时，结果为j的个数；-sum在i=0的位置，0在i=sum的位置
        int[][] dp = new int[nums.length][sum * 2 + 1];
        dp[0][nums[0] + sum] = 1;
        dp[0][-nums[0] + sum]++;
        // 递推公式：dp[i][j] = dp[i-1][j-nums[i]] + dp[i-1][j+nums[i]]
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < sum * 2 + 1; j++) {
                dp[i][j] = (j + nums[i] < sum * 2 + 1 ? dp[i - 1][j + nums[i]] : 0)
                        + (j - nums[i] >= 0 ? dp[i - 1][j - nums[i]] : 0);
            }
        }
        return dp[nums.length - 1][target + sum];
    }
}
