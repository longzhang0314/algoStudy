package cn.zl.algo.week07.heap.common;

/**
 * 大顶堆
 * @author liusha
 * @date 2022/1/10
 */
public class Heap {

    private int[] arr;
    private int n;
    private int count;

    public Heap (int capacity) {
        // 从1开始存数据
        this.arr = new int[capacity + 1];
        this.n = capacity;
        this.count = 0;
    }

    public void insert(int data) {
        // 满了
        if (count >= n) return;
        // 插入最后一个位置，然后自下而上堆化
        ++count;
        arr[count] = data;
        heapifyFromLeaf(arr, count);
    }



    public void removeTop() {
        if (count == 0) return;
        // 堆顶和最后一个元素替换，删除最后一个元素，然后对堆顶元素自上而下堆化
        swap(arr, 1, count);
        --count;
        heapifyFromRoot(arr, 1, count);
    }

    private void heapifyFromRoot(int[] arr, int i, int leaf) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= leaf && arr[i * 2] > arr[i]) maxPos = i * 2;
            if (i * 2 + 1 <= leaf && arr[i * 2 + 1] > arr[maxPos]) maxPos = i * 2 + 1;
            if (maxPos == i) break;
            swap(arr, i, maxPos);
            i = maxPos;
        }
    }

    private void heapifyFromLeaf(int[] arr, int i) {
        while (i / 2  > 0 && arr[i] > arr[i] / 2) {
            swap(arr, i, i / 2);
            i = i / 2;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp  = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public int top() {
        if (count == 0) return -1;
        return arr[1];
    }
}
