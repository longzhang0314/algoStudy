package cn.zl.algo.week04.sort.common;

/**
 * @author liusha
 * @date 2021/12/21
 */
public class ChooseSort {

    public static void main(String[] args) {
        // 2 3 4 2 1 6  不稳定
        int[] arr = {4, 5, 3, 2, 1};
        int n = 5;
        ChooseSort b = new ChooseSort();
        b.sort(arr, n);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    private void sort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int tmp = arr[min];
            arr[min] = arr[i];
            arr[i] = tmp;
        }
    }
}
