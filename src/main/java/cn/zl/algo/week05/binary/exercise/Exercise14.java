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
 *
 * @author liusha
 * @date 2021/12/28
 */
public class Exercise14 {

    public static void main(String[] args) {
        Exercise14 e = new Exercise14();
        int[] arr = {1,1,1,10,10,10};
        int k = 1;
        int x = 9;
        List<Integer> list = e.findClosestElements(arr, k, x);
        for (int num : list) {
            System.out.println(num);
        }
    }


    // O(logN + k)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // 接近x顺序：
        //（1） 相等：第一个等于x，然后向后遍历等于x的
        // (2) 不相等：最后一个小于x的和第一个大于x的比较与x的绝对值

        // 方法：先二分找到等于x的第一个索引、小于x的最后一个索引、大于x的第一个索引；
        // 优先填充等于x的；填充完等于的开始填充小于x和大于x的，用双指针法填充

        int n = arr.length;
        int cnt = k;
        List<Integer> res = new ArrayList<>(k);

        // 不直接填充，只记录左右边界索引
        int leftIdx = -1, rightIdx = -1;

        // 第一个等于x的索引
        int idx = findFirstEqu(arr, x);
        leftIdx = idx;
        while (k > 0 && idx >= 0 && idx < n && arr[idx] == x) {
            rightIdx = idx++;
            k--;
        }
        if (k == 0) {
            addToRes(arr, leftIdx, rightIdx, res);
            return res;
        }

        // 最后一个小于x的索引
        int lastLessIdx = findLastLess(arr, x);
        // 第一个大于x的索引
        int firstMoreIdx = findFirstMore(arr, x);

        while (k > 0 && (lastLessIdx >= 0 || firstMoreIdx < n)) {
            // 左边的更接近，即lastLessIdx更接近
            boolean isLeft = checkLeft(arr, x, lastLessIdx, firstMoreIdx);
            if (isLeft) {
                leftIdx = lastLessIdx--;
            } else {
                rightIdx = firstMoreIdx++;
            }
            k--;
        }

        // 如果没有相等的，且有一侧一直没命中，那么会有负一的情况
        if (leftIdx == -1) {
            leftIdx = rightIdx - cnt + 1;
        } else if (rightIdx == -1) {
            rightIdx = leftIdx + cnt - 1;
        }

        addToRes(arr, leftIdx, rightIdx, res);
        return res;
    }

    private void addToRes(int[] arr, int left, int right, List<Integer> res) {
        for (int i = left; i <= right; i++) {
            res.add(arr[i]);
        }
    }

    private boolean checkLeft(int[] arr, int x, int left, int right) {
        int n = arr.length;
        if (right >= n || right == -1) return true;
        if (left < 0) return false;
        int leftDiff = x - arr[left];
        int rightDiff = arr[right] - x;
        return leftDiff <= rightDiff;
    }

    private int findFirstMore(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > x) {
                if (mid == 0 || arr[mid - 1] <= x) return mid;
                else right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int findLastLess(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < x) {
                if (mid == arr.length - 1 || arr[mid + 1] >= x) return mid;
                else left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int findFirstEqu(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
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


    // =======================================  初次尝试的方法 ==========================================================




    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
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
