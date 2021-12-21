package cn.zl.algo.week04.sort.common;

/**
 * @author liusha
 * @date 2021/12/21
 */
public class InsertSort {


    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 2, 1};
        int n = 5;
        InsertSort b = new InsertSort();
        b.sort(arr, n);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    private void sort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int val = arr[i];
            int j = i - 1;
            for (; j >= 0 && arr[j] > val; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = val;
        }
    }
}
