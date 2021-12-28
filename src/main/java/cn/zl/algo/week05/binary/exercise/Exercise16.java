package cn.zl.algo.week05.binary.exercise;

/**
 * 81. 搜索旋转排序数组2（中等）有重复数据
 *
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。
 * 如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 *
 * 输入：nums = [2,5,6,0,0,1,2], target = 0
 * 输出：true
 *
 * 输入：nums = [2,5,6,0,0,1,2], target = 3
 * 输出：false
 *
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -104 <= target <= 104
 *
 * 分析时间空间复杂度
 *
 * @author liusha
 * @date 2021/12/28
 */
public class Exercise16 {

    // 2 2 3 4 5 6 7 1 2 2
    // 2 3 4 5 6 7 1 1 1
    // 2 2 2 3 4 5 6 7 1
    // 2 2 2 2 5 6 7 1 2 2
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // 特殊情况，两边和mid相等
            if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
                left++;
                right--;
                continue;
            }
            if (nums[mid] >= nums[left]) { // 左边有序
                if (target >= nums[left] && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }














}
