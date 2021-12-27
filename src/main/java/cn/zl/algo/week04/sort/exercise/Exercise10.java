package cn.zl.algo.week04.sort.exercise;

/**
 * 215. 数组中的第K个最大元素（中等）
 *
 * @author: longzhang
 * @date: 2021/12/21
 */
public class Exercise10 {

    public static void main(String[] args) {
        Exercise10 e = new Exercise10();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(e.findKthLargest(nums, k));
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || k > nums.length || k <= 0) return -1;
        return findByQuickSort(nums, 0, nums.length - 1, k);
    }

    private int findByQuickSort(int[] nums, int p, int r, int k) {
        if (p > r) return -1;
        if (p == r) return nums[p];
        // 降序排列
        int partition = partition(nums, p, r);
        if (partition - p + 1 == k) {
            return nums[partition];
        } else if (partition - p + 1 < k) { // 找到的元素太大了，继续往后找
            return findByQuickSort(nums, partition + 1, r, k - partition + p - 1);
        } else { // 太小了，往前找
            return findByQuickSort(nums, p, partition - 1, k);
        }
    }

    // 注意也可以用双指针法
    private int partition(int[] nums, int p, int r) {
        int j = p - 1;
        for (int i = p; i < r; i++) {
            if (nums[i] >= nums[r]) {
                int tmp = nums[i];
                nums[i] = nums[j + 1];
                nums[j + 1] = tmp;
                j++;
            }
        }
        int tmp = nums[r];
        nums[r] = nums[j + 1];
        nums[j + 1] = tmp;
        return j + 1;
    }
}
