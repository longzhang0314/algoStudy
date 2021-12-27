package cn.zl.algo.week05.binary.exercise;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置（中等）
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 * @author liusha
 * @date 2021/12/27
 */
public class Exercise05 {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        // 第一个等于target的
        int first = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    first = mid;
                    break;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (first == -1) return new int[]{-1, -1};
        int second = -1;
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] > target) {
                    second = mid;
                    break;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{first, second};
    }
}
