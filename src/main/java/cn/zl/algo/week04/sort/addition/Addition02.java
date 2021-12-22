package cn.zl.algo.week04.sort.addition;

/**
 * 493. 翻转对（困难）
 *
 * 给定一个数组nums，如果i < j且nums[i] > 2*nums[j]我们就将(i, j)称作一个重要翻转对。
 *
 * 你需要返回给定数组中的重要翻转对的数量。
 *
 * 输入: [1,3,2,3,1]
 * 输出: 2
 *
 * 输入: [2,4,3,5,1]
 * 输出: 3
 *
 * 给定数组的长度不会超过50000。
 * 输入数组中的所有数字都在32位整数的表示范围内。
 *
 * @author: longzhang
 * @date: 2021/12/21
 */
public class Addition02 {

    public static void main(String[] args) {
        Addition02 a = new Addition02();
        // p = 0, q = 2, r = 4
//        int[] nums = {1,3,2,3,1};
//        // 1,2,3 ,1,3
//        int[] nums1 = {-5, -5};
//        int[] nums2 = {2147483647,2147483647,-2147483647,-2147483647,-2147483647,2147483647};
////        System.out.println(a.reversePairs(nums)); // 2
////        System.out.println(a.reversePairs(nums1)); // 1
//        System.out.println(a.reversePairs(nums2)); // 9


    }


    // 逆序对基础上判断2倍的关系
    int cnt = 0;
    public int reversePairs(int[] nums) {
        if (nums == null) return 0;
        mergeSort(nums, 0, nums.length - 1);
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
        int[] tmp = new int[r - p + 1];
        int i = p, j = q + 1, k = 0;

        // 统计翻转对
        calcReversePairs(nums, p, q, r);

        while (i <= q && j <= r) {

            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
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

    private void calcReversePairs(int[] nums, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        while (i <= q && j <= r) {
           if (isReversePairs(nums, i, j)) {
                cnt += (q - i + 1);
                j++;
            } else {
               i++;
           }
        }
    }

    private boolean isReversePairs(int[] nums, int i, int j) {
        int a = nums[i];
        int b = nums[j];
        int border = Integer.MAX_VALUE / 2 + 1;
        int border2 = Integer.MIN_VALUE / 2;
        // 2 * b 越界处理
        if (b >= border) return false;
        if (b < border2) return true;
        return a > b * 2;
    }
}
