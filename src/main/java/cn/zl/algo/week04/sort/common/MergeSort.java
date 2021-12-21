package cn.zl.algo.week04.sort.common;

/**
 * @author liusha
 * @date 2021/12/21
 */
public class MergeSort {

    public static void main(String[] args) {
        MergeSort m = new MergeSort();
        int[] arr = {4, 5, 3, 2, 1};
        int n = 5;
        m.sort(arr, n);
        for (int a : arr) {
            System.out.println(a);
        }
    }

    private void sort(int[] arr, int n) {
        mergeSort(arr, 0, n - 1);
    }

    // T(n) = 2T(n / 2) + n = 2 (2T(n / 4) + 2n) = 4T(n / 4) + 4n = 2^kT(n / 2^k) + 2^k * n
    // n / 2^k = 1  -> k = log2N
    // T(n) = n + n * logN
    // 【注意】递归树分析时间复杂度
    private void mergeSort(int[] arr, int p, int r) {
        if (p >= r) return;
        int q = p + (r - p) / 2;
        mergeSort(arr, p, q);
        mergeSort(arr, q + 1, r);
        merge(arr, p, q, r);
    }

    private void merge(int[] arr, int p, int q, int r) {
        int i = p, j = q + 1;
        int[] tmp = new int[r - p + 1];
        int k = 0;
        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        while (i <= q) {
            tmp[k++] = arr[i++];
        }
        while (j <= r) {
            tmp[k++] = arr[j++];
        }
        for (i = 0; i <= r - p; i++) {
            arr[p + i] = tmp[i];
        }
    }
}
