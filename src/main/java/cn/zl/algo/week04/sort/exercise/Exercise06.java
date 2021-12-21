package cn.zl.algo.week04.sort.exercise;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * @author liusha
 * @date 2021/12/21
 */
public class Exercise06 {

    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
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
