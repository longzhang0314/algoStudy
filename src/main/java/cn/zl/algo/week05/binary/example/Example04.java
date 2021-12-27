package cn.zl.algo.week05.binary.example;

/**
 * 例题4： 循环有序数组中查找最小元素（没有重复数据）
 *
 * TODO 有重复数据
 *
 * 153. 寻找旋转排序数组中的最小值
 *
 * 7、9、10、11、15、1、2、3、4、5、6
 *
 * @author: longzhang
 * @date: 2021/12/26
 */
public class Example04 {

    public static void main(String[] args) {
        Example04 e = new Example04();
        int[] nums = {7, 9, 10, 11, 15, 1, 2, 3, 4, 5, 6};
        int[] nums1 = {7, 9, 10, 11, 15};
        int n = nums.length;
        System.out.println(e.find(nums, n)); // 5
        n = nums1.length;
        System.out.println(e.find(nums1, n)); // 0
    }

    public int find(int[] nums, int n) {
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= nums[(mid - 1 + n) % n] && nums[mid] <= nums[(mid + 1) % n]) {
                return mid;
            } else if (nums[mid] > nums[right]) { // 右边循环有序，在右边找
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


}
