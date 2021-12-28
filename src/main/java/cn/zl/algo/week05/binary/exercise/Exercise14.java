package cn.zl.algo.week05.binary.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 658. 找到K个最接近的元素
 *
 * 给定一个排序好的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 *
 * 整数 a 比整数 b 更接近 x 需要满足：
 *
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 *
 * 输入：arr = [1,2,3,4,5], k = 4, x = 3
 * 输出：[1,2,3,4]
 *
 * 输入：arr = [1,2,3,4,5], k = 4, x = -1
 * 输出：[1,2,3,4]
 *
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 104
 * 数组里的每个元素与 x 的绝对值不超过 104
 *
 * TODO 不够流畅
 *
 * @author liusha
 * @date 2021/12/28
 */
public class Exercise14 {

    public static void main(String[] args) {
        Exercise14 e = new Exercise14();
        int[] arr = {3,5,8,10};
        int k = 2;
        int x = 15;
        List<Integer> list = e.findClosestElements(arr, k, x);
        for (int num : list) {
            System.out.println(num);
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || k <= 0 || k > arr.length) return new ArrayList<>();
        List<Integer> res = new ArrayList<>(k);
        int n = arr.length;
        // 找到等于x的最小数索引；同时找到小于x的最大数和大于x的最小数索引
        int minIdxEquX = findEquX(arr, x);
        int left = minIdxEquX - 1, right = minIdxEquX;
        if (minIdxEquX == -1) {
            int[] leftAndRight = findAroundX(arr, x);
            left = leftAndRight[0];
            right = leftAndRight[1];
        }
        int cnt = 0;
        int low = n, high = -1;
        while ((left >= 0 || right < n) && cnt < k) {
            if (left < 0) {
                high = right;
                low = Math.min(low, right);
                right++;
                cnt++;
                continue;
            }
            if (right >= n) {
                low = left;
                high = Math.max(high, left);
                left--;
                cnt++;
                continue;
            }
            int c = compareTo(arr[left], arr[right], x);
            if (c == -1) {
                low = left;
                high = Math.max(high, left);
                left--;
            } else {
                high = right;
                low = Math.min(low, right);
                right++;
            }
            cnt++;
        }

        if (cnt == 0) {
            if (arr[0] > x) {
                low = 0;
                high = k - 1;
            } else {
                high = n - 1;
                low = high - k + 1;
            }
        }

        for (int i = low; i <= high; i++) {
            res.add(arr[i]);
        }

        return res;
    }

    private int compareTo(int i, int j, int x) {
        if (j - x < x - i) return 1;
        return -1;
    }

    // 调用时没有等于mid的数
    private int[] findAroundX(int[] arr, int x) {
        int n = arr.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == 0 && arr[mid] > x) {
                return new int[]{-1, n};
            } else if (mid == n - 1 && arr[mid] < x) {
                return new int[]{-1, n};
            } else if (mid < n - 1 && arr[mid] < x && arr[mid + 1] > x) {
                return new int[]{mid, mid + 1};
            } else if (mid > 0 && arr[mid] > x && arr[mid - 1] < x) {
                return new int[]{mid - 1, mid};
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{-1, n};
    }

    private int findEquX(int[] arr, int x) {
        int n = arr.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                if (mid == 0 || arr[mid - 1] != x) return mid;
                else right = mid - 1;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
