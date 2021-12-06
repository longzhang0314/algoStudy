package cn.zl.algo.week01.program.exercise;

/**
 * @author liusha
 * @date 2021/12/6
 */
public class Exercise10Test {

    // 有序，原地删除
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}
