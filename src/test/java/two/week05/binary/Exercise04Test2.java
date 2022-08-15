package two.week05.binary;

/**
 * @author liusha
 * @date 2022/8/15
 */
public class Exercise04Test2 {

    public int searchInsert(int[] nums, int target) {
        // insert位置，其实就是第一个大于等于target的位置
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }
        return nums.length;
    }
}
