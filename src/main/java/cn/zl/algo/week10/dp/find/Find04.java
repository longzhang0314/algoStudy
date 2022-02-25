package cn.zl.algo.week10.dp.find;

/**
 * 718. 最长重复子数组
 *
 * @author liusha
 * @date 2022/2/25
 */
public class Find04 {

    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        // 选中[i,j]时的最长重复子数组
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (nums1[i] == nums2[0]) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
            }
        }
        for (int j = 0; j < n; j++) {
            if (nums1[0] == nums2[j]) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = 0;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }


}
