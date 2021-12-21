package cn.zl.algo.week04.sort.common;

/**
 * @author liusha
 * @date 2021/12/21
 */
public class QuickSort {

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int[] arr = {4, 5, 3, 2, 1};
        int n = 5;
        q.sort(arr, n);
        for (int a : arr) {
            System.out.println(a);
        }
    }

    private void sort(int[] arr, int n) {
        quickSort(arr, 0, n - 1);
    }

    private void quickSort(int[] arr, int p, int r) {
        if (p >= r) return;
        int patition = patition(arr, p, r);
        quickSort(arr, p, patition - 1);
        quickSort(arr, patition + 1, r);
    }

    // 两种方式：双指针 TODO 再熟悉写
    private int patition(int[] arr, int p, int r) {
        // [p, j] 小于patition
        int j = p - 1;
        // [j+1, i) 大于patition
        // [i,r) 未处理
        for (int i = p; i < r; i++) {
            if (arr[i] < arr[r]) {
                int tmp = arr[j + 1];
                arr[j + 1] = arr[i];
                arr[i] = tmp;
                j++;
            }
        }
        int tmp = arr[j + 1];
        arr[j + 1] = arr[r];
        arr[r] = tmp;
        return j + 1;
    }
}
