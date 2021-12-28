package cn.zl.algo.week05.binary.exercise;

import com.sun.xml.internal.bind.v2.TODO;

/**
 * 154. 寻找旋转排序数组中的最小值2（困难）有重复元素
 *
 *
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
 *
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
 * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 *
 * 输入：nums = [1,3,5]
 * 输出：1
 *
 * 输入：nums = [2,2,2,0,1]
 * 输出：0
 *
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 *
 * @author liusha
 * @date 2021/12/28
 */
public class Exercise17 {

    // 2 2 3 4 5 6 7 1 2 2
    // 2 3 4 5 6 7 1 1 1
    // 2 2 2 3 4 5 6 7 1
    // 2 2 2 2 5 6 7 1 2 2
    // TODO 还没做完
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            if (left == right) return nums[left];
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[(mid - 1 + n) % n] && nums[mid] < nums[(mid + 1) % n]) {
                return nums[mid];
            }
            if (nums[mid] == nums[left]) {
                left++;
                continue;
            }
            if (nums[mid] == nums[right]) {
                right--;
                continue;
            }

            if (nums[mid] > nums[right]) { // 右边循环有序
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }











}
