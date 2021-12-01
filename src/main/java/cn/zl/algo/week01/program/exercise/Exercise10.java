package cn.zl.algo.week01.program.exercise;

/**
 * 26. 删除排序数组中的重复项（简单）
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class Exercise10 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // j指向新数组中最后一个元素
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;
            nums[++j] = nums[i];
        }
        return j + 1;
    }
}
