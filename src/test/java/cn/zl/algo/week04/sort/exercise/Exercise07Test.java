package cn.zl.algo.week04.sort.exercise;

/**
 * @author liusha
 * @date 2021/12/27
 */
public class Exercise07Test {


    // 000 11 2
    public void sortColors(int[] nums) {
        if (nums == null) return;
        int n = nums.length;
        int i = 0, j = n - 1;
        while (i < j) {
            if (nums[i] == 0) {
                i++;
                continue;
            }
            if (nums[j] != 0) {
                j--;
                continue;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
        j = n - 1;
        while (i < j) {
            if (nums[i] != 2) {
                i++;
                continue;
            }
            if (nums[j] == 2) {
                j--;
                continue;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }

    public void sortColors1(int[] nums) {
        if (nums == null) return;
        int n = nums.length;
        int i = 0, j = n - 1;
        for (int k = 0; k < n; k++) {
            if (nums[k] == 0) {
                // i落后于k的值一定不是0也不是2
                int tmp = nums[i];
                nums[i] = nums[k];
                nums[k] = tmp;
                i++;
            } else if (nums[k] == 2) {
                int tmp = nums[j];
                nums[j] = nums[k];
                nums[k] = tmp;
                j--;
                // 交换完要重新判断下，因为末尾元素未访问，可能是0
                k--;
            }
        }
    }

}
