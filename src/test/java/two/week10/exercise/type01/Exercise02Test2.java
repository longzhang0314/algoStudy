package two.week10.exercise.type01;

/**
 * @author 流沙
 * @date 2024/1/3
 */
public class Exercise02Test2 {

    public static void main(String[] args) {
        Exercise02Test2 e = new Exercise02Test2();
        int[] nums = {1,1,1,1,1}; int target = 3; // except 5
//        int[] nums = {1}; int target = 2; // except 0
        System.out.println(e.findTargetSumWays(nums, target));
    }

    public int findTargetSumWays(int[] nums, int target) {
        // 已知：nums全部非负
        if (nums == null || nums.length == 0 ) return 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (target >=0 && sum < target) return 0;
        if (target < 0 && -sum > target) return 0;

        // i=0代表-sum，i=sum代表0
        // 一维不可行，无法存储前一位+/-的两组结果，所以需要二维数据，其中一位固定长度，总体仍然O(N)空间
        // 滚动数组 i为偶数时占用0，奇数占用1；除0外，其余为i%2
        int[][] dp = new int[2][sum * 2 + 1];
        if (nums[0] + sum < sum * 2 + 1) {
            dp[0][nums[0] + sum] = 1;
        }
        if (-nums[0] + sum >= 0) {
            dp[0][-nums[0] + sum]++;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < sum * 2; j++) {
                dp[i % 2][j] = dp[i % 2][j]
                        + (j - nums[i] >= 0 ? dp[(i - 1) % 2][j - nums[i]] : 0)
                        + (j + nums[i] < sum * 2 + 1 ? dp[(i - 1) % 2][j + nums[i]] : 0);
            }
        }
        return dp[(nums.length - 1) % 2][target + sum];
    }

    // method1：2维dp，finish
    public int findTargetSumWays2(int[] nums, int target) {
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
