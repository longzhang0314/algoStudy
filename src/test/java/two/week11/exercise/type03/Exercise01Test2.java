package two.week11.exercise.type03;

/**
 * TODO 二分解法
 *
 * @author 流沙
 * @date 2024/3/19
 */
public class Exercise01Test2 {

    public static void main(String[] args) {
        Exercise01Test2 e = new Exercise01Test2();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(e.lengthOfLIS(nums)); // 4
    }

    // 300
    ////输入：nums = [10,9,2,5,3,7,101,18]
    ////输出：4
    ////解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        // 以i结尾的LIS
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], nums[i] > nums[j] ? dp[j] + 1 : 0);
            }
        }
        int max = 1;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // 思路：贪心+二分
    // 贪心：顺序遍历数组的情况下，同样长度的LIS，末尾元素越小越好
    // 二分：当前nums[i]
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        // LIS长度为i时的最小末尾值
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        // 全局当前LIS
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > dp[len]) {
                dp[++len] = nums[i];
                continue;
            }
            // TODO 这里二分的目的：找到第一个
            int l = 1, r = len, pos = 0;
            while (l <= r) {
                int mid = (l + r) >>> 1;

            }
        }

    }
}
