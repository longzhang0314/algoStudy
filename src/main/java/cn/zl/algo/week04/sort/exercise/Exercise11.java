package cn.zl.algo.week04.sort.exercise;

/**
 * 面试题 17.14. 最小K个数（中等）
 *
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 *
 * @author: longzhang
 * @date: 2021/12/21
 */
public class Exercise11 {


    // 改进版，快排方法不需要返回值
    int[] ans;
    int count = 0;
    public int[] smallestK(int[] arr, int k) {
        if (arr == null || arr.length < k || k <= 0) return new int[0];
        ans = new int[k];
        quickSort(arr, 0, arr.length - 1, k);
        return ans;
    }

    private void quickSort(int[] arr, int p, int r, int k) {
        if (p > r) return;
        int q = partation(arr, p, r);
        if (q - p + 1 == k) {
            for (int i = p; i <= q; i++) {
                ans[count++] = arr[i];
            }
            return;
        } else if (q - p + 1 < k) {
            for (int i = p; i <= q; i++) {
                ans[count++] = arr[i];
            }
            quickSort(arr, q + 1, r, k - (q - p + 1));
        } else {
            quickSort(arr, p, q - 1, k);
        }
    }

    private int partation(int[] arr, int p, int r) {
        int i = p - 1;
        int j = p;
        while (j < r) {
            if (arr[j] <= arr[r]) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
            j++;
        }
        int tmp = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = tmp;
        return i + 1;
    }

    // ======================================= 方法分隔线 ============================================================


    // 快排，返回第k小的数作为分隔点
    public int[] smallestK2(int[] arr, int k) {
        if (arr == null || arr.length < k || k <= 0) return new int[0];
        int[] res = new int[k];
        int partition = findKByQuickSort(arr, 0, arr.length - 1, k);
        for (int i = 0; i <= partition; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private int findKByQuickSort(int[] arr, int p, int r, int k) {
        if (p > r) return -1;
        if (p == r) return p;
        int q = partition(arr, p, r);
        if (q - p + 1 == k) {
            return q;
        } else if (q - p + 1 < k) {
            return findKByQuickSort(arr, q + 1, r, k - q + p - 1);
        } else {
            return findKByQuickSort(arr, p, q - 1, k);
        }
    }

    private int partition(int [] arr, int p, int r) {
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (arr[j] <= arr[r]) {
                int tmp = arr[j];
                arr[j] = arr[i + 1];
                arr[i + 1] = tmp;
                i++;
            }
        }
        int tmp = arr[r];
        arr[r] = arr[i + 1];
        arr[i + 1] = tmp;
        return i + 1;
    }
}
