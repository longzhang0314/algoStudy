package cn.zl.algo.week04.sort.exercise;

/**
 * @author: longzhang
 * @date: 2021/12/27
 */
public class Exercise10Test {

    public static void main(String[] args) {
        Exercise10Test e = new Exercise10Test();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(e.findKthLargest(nums, k));
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) return -1;
        return quickSort(nums, 0, nums.length - 1, k);
    }

    private int quickSort(int[] nums, int p, int r, int k) {
        if (p > r) return -1;
        int q = partition(nums, p, r);
        if (q - p + 1 == k) {
            return nums[q];
        } else if (q - p + 1 < k) {
            return quickSort(nums, q + 1, r, k - (q - p + 1));
        } else {
            return quickSort(nums, p, q - 1, k);
        }
    }

    private int partition(int[] nums, int p, int r) {
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (nums[j] >= nums[r]) {
                i++;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        int tmp = nums[i + 1];
        nums[i + 1] = nums[r];
        nums[r] = tmp;
        return i + 1;
    }
}
