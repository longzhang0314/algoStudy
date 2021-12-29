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

    public static void main(String[] args) {
        Exercise18 e = new Exercise18();
        int[] nums1 = new int[0];
        int[] nums2 = {1};
        System.out.println(e.findMedianSortedArrays(nums1, nums2));
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) return 0;
        // 对更短的元素做二分查找
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int m = nums1.length, n = nums2.length;
        // 分隔线左侧元素个数（总数奇数的话左侧多一个）
        int total = (m + n + 1) / 2;
        // nums1的分隔线在哪个位置
        int left = 0, right = m;
        int mCnt = 0;
        while (left <= right) {
            int i = left + (right - left) / 2;
            int j = total - i;
            // 交叉小于则满足条件
            if (i == 0) {
                if (m == 0 || nums1[i] >= nums2[j - 1]) {
                    mCnt = i;
                    break;
                } else {
                    left = i + 1;
                }
            } else if (i == m) {
                if (nums1[i - 1] <= nums2[j]) {
                    mCnt = i;
                    break;
                } else {
                    right = i - 1;
                }
            } else if (nums1[i - 1] <= nums2[j] && nums1[i] >= nums2[j - 1]) {
                mCnt = i;
                break;
            } else if (nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
        int nCnt = total - mCnt;

        int mLeft = mCnt == 0 ? Integer.MIN_VALUE : nums1[mCnt - 1];
        int mRight = mCnt == m ? Integer.MAX_VALUE : nums1[mCnt];
        int nLeft = nCnt == 0 ? Integer.MIN_VALUE : nums2[nCnt - 1];
        int nRight = nCnt == n ? Integer.MAX_VALUE : nums2[nCnt];

        if ((m + n) % 2 == 0) {
            return (double) (Math.max(mLeft, nLeft) + Math.min(mRight, nRight)) / 2;
        } else {
            return Math.max(mLeft, nLeft);
        }
    }







}
