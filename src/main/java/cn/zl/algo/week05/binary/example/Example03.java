package cn.zl.algo.week05.binary.example;

/**
 * 例题3：循环有序数组中查找元素x（没有重复元素）
 *
 * TODO 有重复数据
 *
 * 循环有序：7、9、10、11、15、1、2、3、4、5、6
 *
 * @author: longzhang
 * @date: 2021/12/26
 */
public class Example03 {

    public static void main(String[] args) {
        Example03 e = new Example03();
        int[] nums = {7, 9, 10, 11, 15, 1, 2, 3, 4, 5, 6};
        int n = nums.length;
        int x = 2;
        System.out.println(e.find(nums, n, x)); // 6
    }

    public int find(int[] nums, int n, int x) {
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == x) {
                return mid;
            } else if (nums[mid] > nums[left]) {
                if (x >= nums[left] && x < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (x > nums[mid] && x <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }

}
