package two.week05.binary;

/**
 * @author liusha
 * @date 2022/8/16
 */
public class Exercise07Test2 {

    // 33.
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] <= nums[mid]) { // 左边有序，右边循环有序
                if (nums[left] <= target && nums[mid] > target) { // 在左边
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // 右边有序
                if (nums[mid] < target && nums[right] >= target) { // 在右边
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
