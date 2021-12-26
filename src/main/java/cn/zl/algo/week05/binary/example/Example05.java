package cn.zl.algo.week05.binary.example;

/**
 * 例题5. 查找峰值
 *
 * 852.山脉数组的峰顶索引
 *
 * @author: longzhang
 * @date: 2021/12/26
 */
public class Example05 {

    public static void main(String[] args) {
        Example05 e = new Example05();
        int[] nums = {1, 2, 3, 4, 2, 1};
        int n = 6;
        int[] nums1 = {1, 2, 3};
        int n1 = 3;
        int[] nums2 = {3, 2, 1};
        int n2 = 3;
        System.out.println(e.find(nums, n)); // 3
        System.out.println(e.find(nums1, n1)); // 2
        System.out.println(e.find(nums2, n2)); // 0
    }


    public int find(int[] nums, int n) {
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == 0) {
                if (nums[mid] >= nums[right]) return mid;
                else left = mid + 1;
            } else if (mid == n - 1) {
                if (nums[mid] >= nums[left]) return mid;
                else right = mid - 1;
            } else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1]) { // mid处于上行区
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
