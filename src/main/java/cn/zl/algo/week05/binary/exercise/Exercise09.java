package cn.zl.algo.week05.binary.exercise;

/**
 * 852. 山脉数组的峰顶索引
 *
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 *
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 *
 *
 * @author liusha
 * @date 2021/12/27
 */
public class Exercise09 {


    public int peakIndexInMountainArray(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        int n = arr.length;
        if (n == 1) return arr[0];
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == 0) {
                if (arr[mid] > arr[mid + 1]) return mid;
                else left = mid + 1;
            } else if (mid == n - 1) {
                if (arr[mid] < arr[mid - 1]) return mid;
                else right = mid - 1;
            } else if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
