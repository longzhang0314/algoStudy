package two.week05.binary;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liusha
 * @date 2022/8/17
 */
public class Exercise14Test2 {

    public static void main(String[] args) {
        int[] arr = {1};
        int k = 1;
        int x = 0;
        Exercise14Test2 e = new Exercise14Test2();
        System.out.println(e.findClosestElements(arr, k, x));
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>(k);
        int cnt = 0;
        int leftIdx = -1, rightIdx = -1;
        if (arr == null || arr.length < k || k <= 0) return res;
        // 找到第一个等于x的
        int firstEquIdx = findFirstEqu(arr, x);
        leftIdx = firstEquIdx;
        if (firstEquIdx != -1) {
            for (int i = firstEquIdx; i < arr.length && arr[i] == x && cnt < k; i++) {
                rightIdx = i;
                cnt++;
            }
        }
        if (cnt == k) {
            addToRes(arr, res, leftIdx, rightIdx);
            return res;
        }

        // 找到小于x的最大值
        int lastLess = findLastLess(arr, x);
        // 找到大于x的最小值
        int firstMore = findFirstMore(arr, x);

        // 两个都合理，双指针
        while (cnt < k && lastLess >= 0 && firstMore >= 0 && firstMore < arr.length) {
            int leftVal = x - arr[lastLess];
            int rightVal = arr[firstMore] - x;
            if (leftVal <= rightVal) {
                leftIdx = lastLess--;
            } else {
                rightIdx = firstMore++;
            }
            cnt++;
        }

        while (cnt < k && lastLess >= 0) {
            leftIdx = lastLess--;
            cnt++;
        }

        while (cnt < k && firstMore >= 0 && firstMore < arr.length) {
            rightIdx = firstMore++;
            cnt++;
        }

        // 修正特殊情况
        rightIdx = rightIdx == -1 ? leftIdx + k - 1 : rightIdx;
        leftIdx = leftIdx == -1 ? rightIdx - k + 1 : leftIdx;

        addToRes(arr, res, leftIdx, rightIdx);
        return res;
    }

    private void addToRes(int[] arr, List<Integer> res, int leftIdx, int rightIdx) {
        for (int i = leftIdx; i <= rightIdx; i++) {
            res.add(arr[i]);
        }
    }

    private int findFirstMore(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > x) {
                if (mid == 0 || arr[mid - 1] <= x) return mid;
                right = mid - 1;
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
                left = mid + 1;
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
                right = mid - 1;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
