package cn.zl.algo.week12.pointer.exercise;

/**
 * [剑指 Offer 21]调整数组顺序使奇数位于偶数前面
 * @author liusha
 * @date 2022/3/21
 */
public class Exercise05 {

    public int[] exchange(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }
        return nums;
    }

}
