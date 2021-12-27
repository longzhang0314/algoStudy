package cn.zl.algo.week05.binary.exercise;

import javax.print.attribute.standard.NumberUp;

/**
 * 162 寻找峰值（中等）
 *
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 *
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 *
 * @author liusha
 * @date 2021/12/27
 */
public class Exercise10 {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;
        if (n == 1) return 0;
        int left = 0, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == 0) {
                if (nums[mid] > nums[mid + 1]) return mid;
                else left = mid + 1;
            } else if (mid == n - 1) {
                if (nums[mid] > nums[mid - 1]) return mid;
                else right = mid - 1;
            } else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
