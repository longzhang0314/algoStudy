package cn.zl.algo.week04.sort.exercise;

/**
 * 剑指 Offer 51. 数组中的逆序对（困难）
 *
 * @author: longzhang
 * @date: 2021/12/21
 */
public class Exercise12 {

    // 方法1：归并排序
    // 合并的过程中，每次后半段的元素如果小，那么逆序对就要加上前半段当前位置到结尾的元素
    int cnt = 0;
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        mergeSort(nums, 0, n - 1);
        return cnt;
    }

    private void mergeSort(int[] nums, int p, int r) {
        if (p >= r) return;
        int q = p + (r - p) / 2;
        mergeSort(nums, p, q);
        mergeSort(nums, q + 1, r);
        merge(nums, p, q, r);
    }

    private void merge(int[] nums, int p, int q, int r) {
        int i = p, j = q + 1;
        int[] tmp = new int[r - p + 1];
        int k = 0;
        while (i <= q && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                cnt += q - i + 1;
                tmp[k++] = nums[j++];
            }
        }

        while (i <= q) {
            tmp[k++] = nums[i++];
        }

        while (j <= r) {
            tmp[k++] = nums[j++];
        }


        for (i = 0; i <= r - p; i++) {
            nums[p + i] = tmp[i];
        }
    }

    // 方法2：冒泡，交换次数即为逆序对；但会超时
    public int reversePairs2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    flag = true;
                    ++cnt;
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
            if (!flag) break;
        }
        return cnt;
    }
}
