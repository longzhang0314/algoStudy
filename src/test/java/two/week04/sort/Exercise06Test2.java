package two.week04.sort;

/**
 * @author liusha
 * @date 2022/8/8
 */
public class Exercise06Test2 {

    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if ((nums[i] & 1) == 1) {
                i++;
                continue;
            }
            if ((nums[j] & 1) == 0) {
                j--;
                continue;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
        return nums;
    }
}
