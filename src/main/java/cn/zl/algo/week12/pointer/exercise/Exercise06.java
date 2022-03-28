package cn.zl.algo.week12.pointer.exercise;

/**
 * 75. 颜色分类
 *
 * @author liusha
 * @date 2022/3/22
 */
public class Exercise06 {

    // 方法1：两次双指针（容易）
    // 方法2：一次三个区域
    // m1
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        while (j < n) {
            if (nums[j] == 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
            j++;
        }

        int k = i;
        while (i < n) {
            if (nums[i] == 1) {
                int tmp = nums[i];
                nums[i] = nums[k];
                nums[k] = tmp;
                k++;
            }
            i++;
        }
    }


    public void sortColors2(int[] nums) {
        int n = nums.length;
        int j = 0, k = n - 1;
        for (int i = 0; i <= k; i++) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            } else if (nums[i] == 2) {
                int tmp = nums[i];
                nums[i] = nums[k];
                nums[k] = tmp;
                k--;
                i--;
            }
        }
    }














}
