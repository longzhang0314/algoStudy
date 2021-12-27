package cn.zl.algo.week04.sort.exercise;

/**
 * 75. 颜色分类（中等）
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * TODO 重做一遍
 * @author liusha
 * @date 2021/12/21
 */
public class Exercise07 {

    // 方法1：两轮双指针，先把0放前面，再把2放后面
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int i = 0, j = nums.length - 1;
        // 第一轮，0在前
        while (i < j) {
            if (nums[i] == 0) {
                i++;
                continue;
            }
            if (nums[j] != 0) {
                j--;
                continue;
            }
            nums[j] = nums[i];
            nums[i] = 0;
            i++;
            j--;
        }
        // 第二轮，2在后
        j = nums.length - 1;
        while (i < j) {
            if (nums[j] == 2) {
                j--;
                continue;
            }
            if (nums[i] != 2) {
                i++;
                continue;
            }
            nums[i] = nums[j];
            nums[j] = 2;
            i++;
            j--;
        }
    }


    // 方法2：3指针
    public void sortColors2(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int i = 0, j = nums.length - 1; // i是0的下一个位置， j是2的下一个位置
        for (int k = 0; k <= j; k++) {
            if (nums[k] == 0) {
                nums[k] = nums[i];
                nums[i] = 0;
                i++;
            } else if (nums[k] == 2) {
                nums[k] = nums[j];
                nums[j] = 2;
                j--;
                k--;
            }
        }
    }


    public static void main(String[] args) {
        Exercise07 e = new Exercise07();
        int[] arr = {2,0,2,1,1,0};
        e.sortColors2(arr);
        for (int num : arr) {
            System.out.println(num);
        }
    }
}
