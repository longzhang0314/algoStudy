package cn.zl.algo.week05.binary.example;

/**
 * 例题1：查找第一个等于x、最后一个等于x的元素
 * @author: longzhang
 * @date: 2021/12/26
 */
public class Example01 {

    /**
     * 查找第一个值等于给定元素的索引
     * @param nums
     * @param n
     * @return
     */
    public int findFirst(int[] nums, int n, int x) {
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == x) {
                if (mid == 0 || nums[mid - 1] != x) return mid;
                else right = mid - 1;
            } else if (nums[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定元素的索引
     * @param nums
     * @param n
     * @param x
     * @return
     */
    public int findLast(int[] nums, int n, int x) {
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == x) {
                if (mid == n - 1 || nums[mid + 1] != x) return mid;
                else left = mid + 1;
            } else if (nums[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
