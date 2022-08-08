package two.week04.sort;

/**
 * @author liusha
 * @date 2022/8/8
 */
public class Exercise07Test2 {
    // 012
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        // i前都是0，j后都是2
        int i = 0, j = nums.length - 1;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] == 0) {
                int tmp = nums[i];
                nums[i] = nums[k];
                nums[k] = tmp;
                i++;
            } else if (nums[k] == 2) {
                int tmp = nums[j];
                nums[j] = nums[k];
                nums[k] = tmp;
                j--;
                k--;
            }
        }
    }
}
