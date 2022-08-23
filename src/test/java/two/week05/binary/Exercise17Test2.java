package two.week05.binary;

/**
 * @author liusha
 * @date 2022/8/22
 */
public class Exercise17Test2 {

    public static void main(String[] args) {
        int[] nums = {1,3,5};
        Exercise17Test2 e = new Exercise17Test2();
        System.out.println(e.findMin(nums));
    }

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (left == right) {
                return nums[left];
            }
            int mid = left + (right - left) / 2;
            // 小于前一个，一定是拐点
            if (nums[mid] < nums[(mid - 1 + n) % n]) {
                return nums[mid];
            } else if (nums[mid] > nums[mid]) { // 右侧循环有序
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return -1;


        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left =(right - left) / 2;
            if (nums[mid] < nums[(mid - 1 + n) % n] && nums[mid] < nums[(mid + 1) % n]) {
                return nums[mid];
            }
            if (left == right) {
                return nums[left];
            }
            if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
                // 收缩一边，防止多收
                left++;
            } else if (nums[mid] > nums[right]) { // 右边循环有序
                left = mid + 1;
            } else {
                right = mid - 1;
            }


        }
        return -1;
    }

}
