package two.week05.binary;

/**
 * @author liusha
 * @date 2022/8/17
 */
public class Exercise10Test2 {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[(mid - 1 + nums.length) % nums.length]
                    && nums[mid] >= nums[(mid + 1) % nums.length]) {
                return mid;
            }
            if (mid == 0) {
                if (nums[mid] > nums[(mid + 1) % nums.length]) return mid;
                left = mid + 1;
            } else if (mid == nums.length - 1) {
                if (nums[mid] > nums[(mid - 1 + nums.length) % nums.length]) return mid;
                right = mid - 1;
            } else if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
