package cn.zl.algo.week05.binary.example;

/**
 * 例题2：查找第一个大于等于x、最后一个小于等于x的数
 *
 * @author: longzhang
 * @date: 2021/12/26
 */
public class Example02 {

    /**
     * 查找第一个大于等于x的索引
     *
     * @param nums
     * @param n
     * @param x
     * @return
     */
    public int findFirst(int[] nums, int n, int x) {
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= x) {
                if (mid == 0 || nums[mid - 1] < x) return mid;
                else right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 查找最后一个小于等于x的索引
     *
     * @param nums
     * @param n
     * @param x
     * @return
     */
    public int findLast(int[] nums, int n, int x) {
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= x) {
                if (mid == n - 1 || nums[mid + 1] > x) return mid;
                else left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
