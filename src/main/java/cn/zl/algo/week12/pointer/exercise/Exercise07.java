package cn.zl.algo.week12.pointer.exercise;

/**
 * 283.移动零
 *
 * @author liusha
 * @date 2022/3/24
 */
public class Exercise07 {

    // 已排序区间[0,i]，0区间[i+1,j-1]，未考察区间[j,n-1]
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = -1;
        int j = 0;

        while (j < n) {
            if (nums[j] == 0) {
                j++;
                continue;
            }
            nums[i + 1] = nums[j];
            if (i + 1 != j) {
                nums[j] = 0;
            }
            i++;
            j++;
        }
    }

}
