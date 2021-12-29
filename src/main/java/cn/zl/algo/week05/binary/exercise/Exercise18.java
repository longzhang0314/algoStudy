package cn.zl.algo.week05.binary.exercise;

/**
 * 4. 寻找两个正数数组的中位数
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * //输入：nums1 = [1,3], nums2 = [2]
 * //输出：2.00000
 * //解释：合并数组 = [1,2,3] ，中位数 2
 *
 * //输入：nums1 = [1,2], nums2 = [3,4]
 * //输出：2.50000
 * //解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * //输入：nums1 = [], nums2 = [1]
 * //输出：1.00000
 *
 * // nums1.length == m
 * // nums2.length == n
 * // 0 <= m <= 1000
 * // 0 <= n <= 1000
 * // 1 <= m + n <= 2000
 * // -106 <= nums1[i], nums2[i] <= 106
 *
 * @author liusha
 * @date 2021/12/29
 */
public class Exercise18 {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m == 0 && n == 0) return 0;

    }







}
