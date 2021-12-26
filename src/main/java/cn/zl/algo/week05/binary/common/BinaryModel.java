package cn.zl.algo.week05.binary.common;

/**
 * 二分模板
 *
 * @author: longzhang
 * @date: 2021/12/26
 */
public class BinaryModel {

    public int binary(int[] nums, int n, int target) {
        int left = 0, right = n - 1;
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


    public int binaryWithRecursion(int[] nums, int n, int target) {
        return binaryWithRecursion(nums, 0, n - 1, target);
    }

    private int binaryWithRecursion(int[] nums, int left, int right, int target) {
        if (right > left) return -1;
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binaryWithRecursion(nums, mid + 1, right, target);
        } else {
            return binaryWithRecursion(nums, left, right - 1, target);
        }
    }
}
