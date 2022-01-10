package cn.zl.algo.week07.heap.common;

/**
 * 堆排序：从小到大排序，使用大顶堆
 * @author: longzhang
 * @date: 2022/1/10
 */
public class HeapSort {

    // 数组存储在[1,n]的位置
    public void heapSort(int[] arr, int n) {
        // 建堆，类似删除元素，对每个节点自上而下堆化
        buildHeap(arr, n);
        // 堆顶元素和最后一个元素交换，堆长度-1，新的堆顶元素自上而下堆化
        int k = n;
        while (k > 1) {
            swap(arr, 1, k);
            k--;
            heapify(arr, 1, k);
        }
    }

    private void buildHeap(int[] arr, int n) {
        // 非叶子节点自上而下堆化
        for (int i = n / 2; i >= 1; i--) {
            heapify(arr, i, n);
        }
    }

    private void heapify(int[] arr, int i, int n) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && arr[i] < arr[i * 2]) maxPos = i * 2;
            if (i * 2 + 1 <= n && arr[maxPos] < arr[i * 2 + 1]) maxPos = i * 2 + 1;
            if (maxPos == i) break;
            swap(arr, i, maxPos);
            i = maxPos;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
