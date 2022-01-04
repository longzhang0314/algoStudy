package cn.zl.algo.week05.hash.exercise;

/**
 *
 * 剑指 Offer 03 数组中重复的数字(简单)
 *
 * //在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
 * //找出数组中任意一个重复的数字。
 * //
 * // 示例 1：
 * //
 * // 输入：
 * //[2, 3, 1, 0, 2, 5, 3]
 * //输出：2 或 3
 * //
 * //
 * //
 * //
 * // 限制：
 * //
 * // 2 <= n <= 100000
 *
 * TODO 尝试用位图做
 *
 * 讲到此处，1：17：24
 *
 * @author liusha
 * @date 2021/12/30
 */
public class Exercise08 {

    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;
        int[] cnt = new int[n];
        for (int num : nums) {
            cnt[num]++;
            if (cnt[num] > 1) return num;
        }
        return -1;
    }
}
