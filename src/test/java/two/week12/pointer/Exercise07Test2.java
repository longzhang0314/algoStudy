package two.week12.pointer;

import java.util.Arrays;

/**
 * @author 流沙
 * @date 2024/4/7
 */
public class Exercise07Test2 {

    public static void main(String[] args) {
        Exercise07Test2 e= new Exercise07Test2();
        int[] nums = {0,1,0,3,12};
        e.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 283:正向遍历，所有非0去最前面
    // 方法2：所有0去后面：（1）正向遍历：必然导致非0位置不对；（2）倒序遍历：遇到0交换，导致靠后的非0在靠前不对
    public void moveZeroes(int[] nums) {
        if (nums == null) return;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            j++;
        }
    }
}
