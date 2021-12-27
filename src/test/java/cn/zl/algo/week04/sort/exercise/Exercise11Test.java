package cn.zl.algo.week04.sort.exercise;

/**
 * @author: longzhang
 * @date: 2021/12/27
 */
public class Exercise11Test {

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
}
