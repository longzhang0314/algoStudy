package cn.zl.algo.week07.heap.common;

/**
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

    }

    public void removeTop() {
        // 堆顶和最后一个元素替换，删除最后一个元素，然后对堆顶元素自上而下堆化

    }

    public int top() {
        if (count == 0) return -1;
        return arr[1];
    }
}
