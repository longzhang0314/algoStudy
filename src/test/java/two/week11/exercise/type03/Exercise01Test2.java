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
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int n = nums.length;
            // 贪心 + 二分：访问到i时，同样的LIS长度，末尾元素越小，越有利于全局的LIS长度
            // dp数组定义：长度为i的LIS对应的最小末尾元素，方便处理边界情况定义为长度为i+1
            int[] dp = new int[n];
            dp[0] = nums[0];
            // 全局LIS-1
            int len = 0;
            // 遍历到i时，对比nums[i]和dp[j<max]
            //   如果nums[i]大于所有dp[j<max]，那么dp[max+1]=nums[i]，max++;
            //   否则找到位置j，其中dp[j-1]<nums[i]<dp[j] => dp[j]=nums[i]
            for (int i = 1; i < n; i++) {
                if (nums[i] > dp[len]) {
                    dp[++len] = nums[i];
                } else {
                    // 找到j，dp[j - 1] < nums[i] < dp[j]
                    int left = 0, right = len;
                    int j = -1;
                    while (left <= right) {
                        int mid = left + (right - left) / 2;
                        if (dp[mid] <= nums[i]) {
                            left = mid + 1;
                        } else {
                            if (mid == 0 || dp[mid - 1] < nums[i]) {
                                j = mid;
                                break;
                            } else {
                                right = mid - 1;
                            }
                        }
                    }
                    if (j != -1) dp[j] = nums[i];
                }
            }
            return len + 1;
        }
    }
}
