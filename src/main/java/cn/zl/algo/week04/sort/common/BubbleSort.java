package cn.zl.algo.week04.sort.common;

/**
 * @author liusha
 * @date 2021/12/21
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 2, 1};
        int n = 5;
        BubbleSort b = new BubbleSort();
        b.sort(arr, n);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    public void sort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
}
