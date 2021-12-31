package cn.zl.algo.week05.hash.exercise;

/**
 * 1122. 数组的相对排序(简单)
 *
 * //给你两个数组，arr1 和 arr2，
 * //
 * // arr2 中的元素各不相同
 * // arr2 中的每个元素都出现在 arr1 中
 * //
 * // 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * //
 * //输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * //输出：[2,2,2,1,4,3,3,9,6,7,19]
 * //
 * // 1 <= arr1.length, arr2.length <= 1000
 * // 0 <= arr1[i], arr2[i] <= 1000
 * // arr2 中的元素 arr2[i] 各不相同
 * // arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 * @author liusha
 * @date 2021/12/31
 */
public class Exercise13 {

    // 方法1：计数排序
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // m > n, arr2 is model
        int m = arr1.length, n = arr2.length;
        // 统计arr1中每个元素出现了几次
        int[] cnt = new int[1001];
        for (int a1 : arr1) {
            cnt[a1]++;
        }
        int[] ans = new int[m];
        int idx = 0;
        for (int a2 : arr2) {
            while (cnt[a2] > 0) {
                ans[idx++] = a2;
                cnt[a2]--;
            }
        }
        for (int i = 0; i < 1001; i++) {
            while (cnt[i] > 0) {
                ans[idx++] = i;
                cnt[i]--;
            }
        }
        return ans;
    }

}
