package cn.zl.algo.week05.binary.exercise;

/**
 * 704. 二分查找（简单）标准二分查找
 * @author liusha
 * @date 2021/12/27
 */
public class Exercise01 {


    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
