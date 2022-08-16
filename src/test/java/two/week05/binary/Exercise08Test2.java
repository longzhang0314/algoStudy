package two.week05.binary;

/**
 * @author liusha
 * @date 2022/8/16
 */
public class Exercise08Test2 {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= nums[(mid - 1 + nums.length) % nums.length]) {
                return nums[mid];
            }

            if (nums[mid] > nums[right]) { // 右边循环有序，在右边
                left = mid + 1;
            } else { // 在左边（包含左边循环有序、或者无旋转）
                right = mid - 1;
            }
        }
        return -1;
    }
}
