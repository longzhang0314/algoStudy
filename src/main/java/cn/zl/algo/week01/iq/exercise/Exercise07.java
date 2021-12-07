package cn.zl.algo.week01.iq.exercise;

/**
 * 55. 跳跃游戏 （中等）
 * 【注意】容易忘记思路，以及证明解法可行
 *
 * 【注意】原始思路解法，可达数组
 */
public class Exercise07 {

    /**
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     *
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标。
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        // 能够到达的最远距离
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            // 当前位置比前面能到达的最远距离还远
            if (i > k) return false;
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }


    // 原始思路，逐步标记科大点
    public boolean canJump1(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        int n = nums.length;
        boolean[] run = new boolean[n];
        run[0] = true;
        for (int i = 0; i < n; i++) {
            if (!run[i]) return false;
            for (int j = 0; i + j < n && j <= nums[i]; j++) {
                run[i + j] = true;
            }
        }
        return true;
    }
}
