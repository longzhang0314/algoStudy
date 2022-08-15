package two.week04.sort;

/**
 * @author liusha
 * @date 2022/8/10
 */
public class Exercise12Test2 {

    int cnt = 0;
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        mergeSort(nums, 0, nums.length - 1);
        return cnt;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] res = new int[right - left + 1];
        int k = 0;
        int i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                res[k++] = nums[i++];
            } else {
                cnt += (mid - i + 1);
                res[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            res[k++] = nums[i++];
        }

        while (j <= right) {
            res[k++] = nums[j++];
        }

        for (int m = 0; m < right - left + 1; m++) {
            nums[left + m] = res[m];
        }
    }
}
