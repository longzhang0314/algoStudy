package two.week05.binary;

/**
 * @author liusha
 * @date 2022/8/22
 */
public class Exercise16Test2 {

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[right] && nums[mid] == nums[left]) {
                left++;
                right--;
            } else if (nums[mid] >= nums[left]) { // 左边有序
                if (nums[left] <= target && nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            } else {
                if (nums[right] >= target && nums[mid] < target) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }
}
